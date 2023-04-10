package com.example.eventi.viewmodels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.repository.interests.LocalStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    private val repository: LocalStorageRepository
) : ViewModel() {
    private var _interestsData = generateInterestsOptions().toMutableStateList()
    val interestsData: List<Interest>
        get() = _interestsData

    private val _savedInterests = MutableStateFlow<List<Interest>>(emptyList())

    val savedInterests: StateFlow<List<Interest>>
        get() = _savedInterests
    init {
        getAllSavedInterests()
    }

    var userSelectedInterests: MutableList<Interest> = mutableListOf()

    fun changeInterestSelected(interest: Interest, checked: Boolean) {
        _interestsData.find { it.id == interest.id }?.let {
            interest.isSelected = checked
        }

        if (checked) {
            userSelectedInterests.add(interest)
        } else {
            userSelectedInterests.remove(interest)
        }
    }

    private fun getAllSavedInterests() = viewModelScope.launch {
        repository.getInterests().collect {
            _savedInterests.value = it
        }
    }

    fun addInterestsToStorage() = viewModelScope.launch {
        repository.addInterests(userSelectedInterests)
    }

    fun clearRecentInterests() = viewModelScope.launch {
        repository.clearAllInterests()
    }
}

private fun generateInterestsOptions() =
    List(interestsTopics.size) { i -> Interest(id = i, label = interestsTopics[i]) }

private val interestsTopics = listOf(
    "Academic",
    "Community",
    "Concerts",
    "Conferences",
    "Expos",
    "Festivals",
    "Performing Arts",
    "Sports"
)