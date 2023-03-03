package com.example.eventi.repository.interests

import com.example.eventi.data.EntityMapper
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity
import io.realm.Realm
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalStorageRepositoryImpl @Inject constructor(
    private val realm: Realm,
    private val mapper: EntityMapper
) : LocalStorageRepository {
    override fun getInterests() = flow {
        realm.use { it ->
            realm.beginTransaction()
            emit(it.where(InterestEntity::class.java)
                .findAllAsync()
                .map {
                    Interest(
                        id = 0,
                        it.content
                    )
                }
            )
            realm.commitTransaction()
        }
    }

    override fun addInterests(interests: List<Interest>) {
        realm.executeTransaction {
            interests.forEach {
                realm.insertOrUpdate(mapper.mapToInterestEntity(it))
            }
        }
    }

    override fun clearAllInterests() {
        realm.executeTransactionAsync {
            it.where(InterestEntity::class.java)
                .findAllAsync()
                .deleteAllFromRealm()
        }
    }
}
