package com.example.eventi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.network.Event
import com.example.eventi.di.DispatcherIO
import com.example.eventi.repository.events.EventRepository
import com.example.eventi.repository.interests.LocalStorageRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val localStorageRepository: LocalStorageRepositoryImpl,
    @DispatcherIO private val dispatcherIO: CoroutineDispatcher
) : ViewModel() {
    private val _events = MutableStateFlow<List<List<Event>>>(emptyList())
    val events: StateFlow<List<List<Event>>>
        get() = _events

    private val _savedInterests = MutableStateFlow<List<Interest>>(emptyList())

    init {
        fetchInterests()
        fetchEvents()
    }

    fun fetchEvents() = viewModelScope.launch {
        try {
            val newEvents = withContext(dispatcherIO) {
                val eventsByCategory = mutableListOf<List<Event>>()

                for (interest in _savedInterests.value) {
                    eventsByCategory.add(eventRepository.findEventsByCategory(interest.label))
                }

                eventsByCategory
            }
            _events.value = newEvents
        } catch (e: Exception) {
            _events.value = listOf()
        }
    }

    private fun fetchInterests() = viewModelScope.launch {
        localStorageRepository.getInterests().collect {
            _savedInterests.value = it
        }
    }
}