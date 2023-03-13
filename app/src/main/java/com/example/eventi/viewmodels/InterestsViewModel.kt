package com.example.eventi.viewmodels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.eventi.data.local.interests.Interest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

//@HiltViewModel
class InterestsViewModel : ViewModel() {
    private var _interestsData = generateInterestsOptions().toMutableStateList()
    val interestsData: List<Interest>
        get() = _interestsData

    var userSelectedInterests: MutableList<Interest> = mutableListOf()

    private val _savedInterests = MutableStateFlow<List<Interest>>(emptyList())
    val savedInterests: StateFlow<List<Interest>>
        get() = _savedInterests

//    init {
//        getAllSavedInterests()
//    }

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

//    @OptIn(FlowPreview::class)
//    fun getAllSavedInterests() = viewModelScope.launch {
//        _savedInterests.value = repository.getInterests().flatMapConcat {
//            it.asFlow()
//        }.toList()
//    }
//
//
//    fun addInterestsToStorage() = viewModelScope.launch {
//        repository.addInterests(userSelectedInterests)
//    }
//
//    fun clearRecentInterests() = viewModelScope.launch {
//        repository.clearAllInterests()
//    }
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