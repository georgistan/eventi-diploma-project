package com.example.eventi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.data.network.events.EventApiStatus
import com.example.eventi.di.DispatcherIO
import com.example.eventi.data.network.events.Event
import com.example.eventi.repository.events.EventRepositoryImpl
import com.example.eventi.repository.interests.LocalStorageRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventRepository: EventRepositoryImpl,
    private val localStorageRepository: LocalStorageRepositoryImpl,
    @DispatcherIO private val dispatcherIO: CoroutineDispatcher
) : ViewModel() {
    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>>
        get() = _events

    private var _status = MutableLiveData<EventApiStatus>()
    var status: LiveData<EventApiStatus> = _status

    init {
        getEvents()
    }

    private fun getEvents() {
        viewModelScope.launch {
            _status.value = EventApiStatus.LOADING
            try {
                val newEvents = withContext(dispatcherIO) {
                    eventRepository.getEvents()
                }
                _events.value = newEvents
                _status.value = EventApiStatus.DONE
            } catch (e: Exception) {
                _events.value = listOf()
                _status.value = EventApiStatus.ERROR
            }
        }
    }

    fun getEvent(eventId: String): Event? {
        return events.value.find { it.id == eventId }
    }

    fun manageEventAttendance(event: Event) {
        viewModelScope.launch {
            localStorageRepository.manageEventAttendance(event = event)
        }
    }

}