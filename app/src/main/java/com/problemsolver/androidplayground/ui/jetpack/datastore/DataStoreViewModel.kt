package com.problemsolver.androidplayground.ui.jetpack.datastore

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.androidplayground.data.repository.LocalRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DataStoreViewModel @ViewModelInject constructor(
    private val localRepository: LocalRepository
) : ViewModel() {

    private val _dataText = MutableLiveData<String>()
    val dataText: LiveData<String>
        get() = _dataText

    init {
        getDataText()
    }

    private fun getDataText() {
        viewModelScope.launch {
            localRepository.getExampleData().collectLatest {
                _dataText.value = it
            }
        }
    }

    fun setDataText(dataText: String) {
        viewModelScope.launch {
            localRepository.setExampleData(dataText)
        }
    }
}