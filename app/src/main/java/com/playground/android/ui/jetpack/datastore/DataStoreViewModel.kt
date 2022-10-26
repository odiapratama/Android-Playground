package com.playground.android.ui.jetpack.datastore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playground.android.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
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