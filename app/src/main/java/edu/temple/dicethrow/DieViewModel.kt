package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel: ViewModel() {
//    private val _currentDieValue = MutableLiveData<Int>()
//    val currentDieValue: LiveData<Int>
//        get() = _currentDieValue

    private val currentDieValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getCurrentRoll(): LiveData<Int> {
        return currentDieValue
    }

    fun setCurrentRoll(roll: Int) {
        currentDieValue.value = roll
    }
}