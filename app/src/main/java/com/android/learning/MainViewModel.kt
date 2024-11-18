package com.android.learning

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel(){
     val numberTimesClicked = MutableLiveData<Int>()
//    val numberTimesClicked : StateFlow<Int?> = _numberTimesClicked.asStateFlow()
    init {
        numberTimesClicked.value = 0
    }
    fun onButtonClick() {
        numberTimesClicked.value = numberTimesClicked.value?.plus(1)
    }
}