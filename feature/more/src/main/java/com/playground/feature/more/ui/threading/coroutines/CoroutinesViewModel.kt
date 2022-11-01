package com.playground.feature.more.ui.threading.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoroutinesViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Int>>()
    val data: LiveData<List<Int>>
        get() = _data

    fun getLoadData() {
    }
}