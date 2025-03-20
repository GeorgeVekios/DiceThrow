package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel: ViewModel() {
//    private val _currentDieValue = MutableLiveData<Int>()
//    val currentDieValue: LiveData<Int>
//        get() = _currentDieValue

    private var dieSides: Int = 6

    private val currentDieValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getCurrentRoll(): LiveData<Int> {
        return currentDieValue
    }

    fun setCurrentRoll(roll: Int) {
        currentDieValue.value = roll
    }

    fun rollDie(){
        setCurrentRoll(Random.nextInt(dieSides)+1)
    }
}