package com.playground.feature.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playground.feature.home.data.model.ResultData
import com.playground.feature.home.data.model.TrendingItem
import com.playground.feature.home.data.repository.TrendingRepository
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