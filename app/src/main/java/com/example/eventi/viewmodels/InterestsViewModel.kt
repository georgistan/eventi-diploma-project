package com.example.eventi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.repository.interests.Interest
import com.example.eventi.repository.interests.LocalStorageRepository
import com.example.eventi.repository.interests.LocalStorageRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    private val localStorageRepositoryImpl: LocalStorageRepositoryImpl
) : ViewModel() {
    private val _recentInterests = MutableStateFlow<List<Interest>>(emptyList())
    val recentInterests: StateFlow<List<Interest>>
        get() = _recentInterests

//    init {
//        getAllRecentInterests()
//    }

//    fun addInterest(interest: String){
//        _recentInterests.value.
//    }

    private fun getAllRecentInterests() = viewModelScope.launch {
         localStorageRepositoryImpl.getRecentInterests().onEach {
             _recentInterests.value = it
         }.collect()
    }

    fun addRecentInterests(Interests:List<Interest>) = viewModelScope.launch {
        localStorageRepositoryImpl.addRecentInterests(Interests)
    }

    fun clearRecentInterests() = viewModelScope.launch {
        localStorageRepositoryImpl.clearAllRecentInterests()
    }
}