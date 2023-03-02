package com.example.eventi.viewmodels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.eventi.repository.interests.Interest

class TestViewModel : ViewModel() {
    private var _interestsList = getInterests().toMutableStateList()
    val interestsList: List<Interest>
        get() = _interestsList

    private var userSelectedInterests: MutableList<Interest> = mutableListOf()

    private fun removeInterest(interest: Interest) {
        _interestsList.remove(interest)
    }

    fun changeTaskChecked(interest: Interest, checked: Boolean) {
        _interestsList.find { it.id == interest.id }?.let {
            interest.isSelected = checked
        }

        if(checked){
            userSelectedInterests.add(interest)
        } else {
            userSelectedInterests.remove(interest)
        }

        println("INTERESTS LIST = ${userSelectedInterests.size}")
    }

}

private fun getInterests() =
    List(interestsData.size) { i -> Interest(id = i, label = interestsData[i]) }

private val interestsData = listOf(
    "Academic",
    "Community",
    "Concerts",
    "Conferences",
    "Expos",
    "Festivals",
    "Performing Arts",
    "Sports"
)