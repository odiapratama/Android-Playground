package com.problemsolver.androidplayground.activities.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.androidplayground.data.model.TrendingItem
import com.problemsolver.androidplayground.data.repository.TrendingRepository
import com.problemsolver.androidplayground.data.model.ResultData
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val trendingRepository: TrendingRepository
) : ViewModel() {

    private val _trending = MutableLiveData<ResultData<List<TrendingItem>>>()
    val trending: LiveData<ResultData<List<TrendingItem>>>
        get() = _trending

    init {
        viewModelScope.launch {
            trendingRepository.getTrending().let {
                _trending.postValue(it.value)
            }
        }
    }
}