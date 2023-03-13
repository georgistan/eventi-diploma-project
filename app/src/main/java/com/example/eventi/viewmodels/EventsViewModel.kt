package com.example.eventi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.data.local.interests.Interest
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
    private val _events = MutableStateFlow<List<List<Event>>>(emptyList())
    val events: StateFlow<List<List<Event>>>
        get() = _events

    private var _status = MutableLiveData<EventApiStatus>()
    var status: LiveData<EventApiStatus> = _status

    private val _savedInterests = MutableStateFlow<List<Interest>>(emptyList())

    init {
        fetchInterests()
    }

    private fun fetchInterests() = viewModelScope.launch {
        localStorageRepository.getInterests().collect {
            _savedInterests.value = it
        }
    }

    fun fetchEvents(): StateFlow<List<List<Event>>> {
        viewModelScope.launch {
            _status.value = EventApiStatus.LOADING
            try {
                val newEvents = withContext(dispatcherIO) {
                    val eventsByCategory = mutableListOf<List<Event>>()

                    for (interest in _savedInterests.value){
                        eventsByCategory.add(eventRepository.getEventsByCategory(interest.label))
                    }

                    eventsByCategory
                }
                _events.value = newEvents
                _status.value = EventApiStatus.DONE
            } catch (e: Exception) {
                _events.value = listOf()
                _status.value = EventApiStatus.ERROR
            }
        }

        return events
    }

    fun fetchEvent(eventId: String): Event? {
        return events.value.get(0).find { it.id == eventId }
    }

    fun manageEventAttendance(event: Event) {
        viewModelScope.launch {
            localStorageRepository.manageEventAttendance(event = event)
        }
    }

}