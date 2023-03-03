package com.example.eventi.repository.interests

import com.example.eventi.data.local.interests.Interest
import kotlinx.coroutines.flow.Flow

interface LocalStorageRepository {
    fun getInterests(): Flow<List<Interest>>

    fun addInterests(interests: List<Interest>)

    fun clearAllInterests()
}

