package com.example.eventi.repository.interests

import kotlinx.coroutines.flow.Flow

interface LocalStorageRepository {
    suspend fun getRecentInterests(): Flow<List<Interest>>

    suspend fun addRecentInterests(interests: List<Interest>)

    suspend fun clearAllRecentInterests()
}

