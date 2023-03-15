package com.example.eventi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.data.network.Event
import com.example.eventi.repository.events.EventRepository
import com.example.eventi.repository.interests.LocalStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleEventViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val localStorageRepository: LocalStorageRepository
) : ViewModel() {
    private val _queriedEvent = MutableStateFlow(Event())
    val queriedEvent: StateFlow<Event>
        get() = _queriedEvent

    private val _isQueriedEventAttended = MutableStateFlow(false)
    val isQueriedEventAttended: StateFlow<Boolean>
        get() = _isQueriedEventAttended

    fun fetchEventById(eventId: String) {
        viewModelScope.launch {
            _queriedEvent.value = eventRepository.findEventById(eventId)
        }
    }

    fun manageEventAttendance(event: Event) {
        viewModelScope.launch {
            localStorageRepository.manageEventAttendance(event)
        }
        _isQueriedEventAttended.value = !_isQueriedEventAttended.value
    }

    fun checkEventAttended(eventId: String) {
        viewModelScope.launch {
            _isQueriedEventAttended.value = localStorageRepository.checkEventStored(eventId)
        }
    }
}