package com.playground.android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playground.android.data.model.TrendingItem
import com.playground.android.data.repository.TrendingRepository
import com.playground.android.data.model.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val trendingRepository: TrendingRepository
) : ViewModel() {

    private val _trending = MutableLiveData<ResultData<List<TrendingItem>>>()
    val trending: LiveData<ResultData<List<TrendingItem>>>
        get() = _trending

    init {
        getTrending()
    }

    private fun getTrending() {
        _trending.postValue(ResultData.Loading)
        viewModelScope.launch {
            trendingRepository.getTrending().let {
                _trending.postValue(it)
            }
        }
    }
}