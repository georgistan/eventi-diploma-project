package com.example.eventi.repository.interests

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eventi.data.EntityMapper
import com.example.eventi.data.local.events.RealmEvent
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity
import com.example.eventi.data.network.Event
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import javax.inject.Provider

class LocalStorageRepositoryImpl(
    private val realm: Provider<Realm>,
    private val mapper: EntityMapper,
    private val dispatcherIO: CoroutineDispatcher
) : LocalStorageRepository {
    override suspend fun addInterests(interests: List<Interest>) {
        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                interests.forEach { curr ->
                    transaction.insertOrUpdate(mapper.mapToInterestEntity(curr))
                }
            }
        }
    }

    override fun getInterests() = flow {
        var result: List<Interest> = listOf()

        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                result = transaction.where(InterestEntity::class.java)
                    .findAll()
                    .map { curr ->
                        mapper.mapFromInterestEntity(curr)
                    }
            }
        }

        emit(result)
    }

    override suspend fun clearAllInterests() {
        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                transaction.where(InterestEntity::class.java).findAll().deleteAllFromRealm()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun manageEventAttendance(event: Event) {
        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                val eventToBeManaged = transaction.where(RealmEvent::class.java)
                    .equalTo("id", event.id)
                    .findFirst()

                when (eventToBeManaged) {
                    null -> {
                        transaction.insert(mapper.mapToRealmEvent(event))
                    }
                    else -> {
                        eventToBeManaged.isAttended = false
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun checkEventAttended(eventId: String): Boolean {
        var result: RealmEvent?
        var isAttended = false

        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                result = transaction.where(RealmEvent::class.java)
                    .equalTo("id", eventId)
                    .findFirst()

                if (result != null) {
                    val mappedResult = result?.let {
                        mapper.mapFromRealmEvent(it)
                    }

                    isAttended = when (mappedResult?.isAttended) {
                        true -> false
                        else -> true
                    }
                }
            }
        }

        return isAttended
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getEvents() = flow {
        var result: List<Event> = listOf()

        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                result = transaction.where(RealmEvent::class.java)
                    .equalTo("isAttended", true)
                    .findAll()
                    .map { curr ->
                        mapper.mapFromRealmEvent(curr)
                    }
            }
        }

        emit(result)
    }
}
