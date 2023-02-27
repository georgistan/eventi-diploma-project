package com.example.eventi.repository.interests

import androidx.lifecycle.LiveData
import com.example.eventi.Interest

interface LocalStorageRepository {
    suspend fun getRecentInterests(): LiveData<List<Interest>>

    suspend fun addRecentInterests(interests: List<Interest>)

    suspend fun clearAllRecentInterests()
}