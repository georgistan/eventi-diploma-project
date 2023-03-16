package com.example.eventi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.data.network.Event
import com.example.eventi.repository.interests.LocalStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoriesViewModel @Inject constructor(
    private val localStorageRepository: LocalStorageRepository
) : ViewModel() {
    private val _attendedEvents = MutableStateFlow<List<Event>>(emptyList())
    val attendedEvents: StateFlow<List<Event>>
        get() = _attendedEvents

    init {
        fetchAttendedEvents()
    }

    private fun fetchAttendedEvents() = viewModelScope.launch {
        localStorageRepository.getEvents().collect {
            _attendedEvents.value = it
        }
    }
}