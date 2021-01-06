package com.example.sandbox

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LifecycleSampleViewModel: ViewModel() {

    val myLiveData = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        myLiveData.postValue("asd")
    }
}