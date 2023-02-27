package com.example.eventi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.Interest
import com.example.eventi.repository.interests.LocalStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProtoViewModel @Inject constructor(
    private val localStorageRepository: LocalStorageRepository
) : ViewModel() {
    private lateinit var _recentInterests: LiveData<List<Interest>>
    val recentInterests: LiveData<List<Interest>> = _recentInterests

    init {
        getAllRecentInterests()
    }

    private fun getAllRecentInterests() = viewModelScope.launch {
        _recentInterests = localStorageRepository.getRecentInterests()
    }

    fun addRecentInterests(Interests:List<Interest>) = viewModelScope.launch {
        localStorageRepository.addRecentInterests(Interests)
    }

    fun clearRecentInterests() = viewModelScope.launch {
        localStorageRepository.clearAllRecentInterests()
    }
}