package com.example.eventi.repository.interests

import io.realm.Realm
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalStorageRepositoryImpl @Inject constructor(
    private val realm: Realm
) : LocalStorageRepository {
    override suspend fun getRecentInterests() = flow {
        realm.use { it ->
            realm.beginTransaction()
            emit(it.where(InterestEntity::class.java)
                .findAll()
                .map {
                    Interest(
                        it.id,
                        it.content
                    )
                }
            )
            realm.commitTransaction()
        }
    }
    override suspend fun addRecentInterests(interests: List<Interest>) {
        TODO("Not yet implemented")
    }

    override suspend fun clearAllRecentInterests() {
        TODO("Not yet implemented")
    }
}
