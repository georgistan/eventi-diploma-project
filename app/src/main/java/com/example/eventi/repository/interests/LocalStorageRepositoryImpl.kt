package com.example.eventi.repository.interests

import com.example.eventi.data.EntityMapper
import com.example.eventi.data.local.events.RealmEvent
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity
import com.example.eventi.data.network.Event
import com.example.eventi.di.DispatcherIO
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

class LocalStorageRepositoryImpl (
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
                result = transaction.where(InterestEntity::class.java).findAll().map { curr ->
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

    override suspend fun manageEventAttendance(event: Event) {
        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                transaction.insertOrUpdate(mapper.mapToRealmEvent(event))
            }
        }
    }

    override suspend fun checkEventStored(eventId: String): Boolean {
        var result: RealmEvent?
        var isStored: Boolean = false

        realm.get().use { realm ->
            realm.executeTransactionAwait(dispatcherIO) { transaction ->
                result =
                    transaction.where(RealmEvent::class.java).equalTo("id", eventId).findFirst()

                isStored = (result != null)
            }
        }

        return isStored
    }

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
