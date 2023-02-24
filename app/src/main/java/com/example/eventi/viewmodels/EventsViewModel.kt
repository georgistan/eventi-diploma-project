package com.example.eventi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventi.data.network.events.EventApiStatus
import com.example.eventi.di.DefaultDispatcher
import com.example.eventi.repository.events.Event
import com.example.eventi.repository.events.EventRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val repository: EventRepositoryImpl,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
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
                val newEvents = withContext(defaultDispatcher) {
                    repository.getEvents()
                }
                _events.value = newEvents
                _status.value = EventApiStatus.DONE
            } catch (e: Exception) {
                _events.value = listOf()
                _status.value = EventApiStatus.ERROR
            }
        }
    }
}