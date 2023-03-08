package com.example.eventi.repository.interests

import com.example.eventi.data.EntityMapper
import com.example.eventi.data.local.events.RealmEvent
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity
import com.example.eventi.data.network.events.Event
import com.example.eventi.di.DispatcherIO
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Provider

class LocalStorageRepositoryImpl @Inject constructor(
    private val realm: Provider<Realm>,
    private val mapper: EntityMapper,
    @DispatcherIO private val dispatcherIO: CoroutineDispatcher
) : LocalStorageRepository {
    override fun getInterests() = flow {
        var result: List<Interest> = listOf()

        realm.get().use {
            it.executeTransactionAwait(dispatcherIO) {
                result = it.where(InterestEntity::class.java)
                    .findAll()
                    .map {
                        mapper.mapFromInterestEntity(it)
                    }
            }
        }
        emit(result)
    }

    override suspend fun addInterests(interests: List<Interest>) {
        realm.get().use {
            it.executeTransactionAwait(dispatcherIO) { transaction ->
                interests.forEach {
                    transaction.insert(mapper.mapToInterestEntity(it))
                }
            }
        }
    }

    override suspend fun clearAllInterests() {
        realm.get().use {
            it.executeTransactionAwait(dispatcherIO) {
                it.where(InterestEntity::class.java)
                    .findAll()
                    .deleteAllFromRealm()
            }
        }
    }

    suspend fun manageEventAttendance(event: Event) {
        var result: RealmEvent?

        realm.get().use {
            it.executeTransactionAwait(dispatcherIO) { realm ->
                result = realm.where(RealmEvent::class.java)
                    .equalTo("id", event.id)
                    .findFirst()

                if (result == null){
                    realm.insert(
                            RealmEvent(
                                id = event.id,
                                category = event.category,
                                isAttended = true
                            )
                        )
                } else {
                    result?.deleteFromRealm()
                }
            }
        }

    }
}
