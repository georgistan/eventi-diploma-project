package com.example.eventi.repository.interests

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eventi.Interest
import com.example.eventi.RecentInterests
import javax.inject.Inject

class LocalStorageRepositoryImpl @Inject constructor(
    private val context: Context,
    private val recentInterestsDataStore: DataStore<RecentInterests>
) : LocalStorageRepository {
    override suspend fun getRecentInterests(): LiveData<List<Interest>> {
        return recentInterestsDataStore.data.asLiveData()
            .switchMap { MutableLiveData(it.interestsList) }
    }

    override suspend fun addRecentInterests(interests: List<Interest>) {
        recentInterestsDataStore.updateData { recentInterests: RecentInterests ->
            recentInterests.toBuilder().addAllInterest(interests).build()
        }
    }

    override suspend fun clearAllRecentInterests() {
        recentInterestsDataStore.updateData {
            it.toBuilder().clear().build()
        }
    }
}