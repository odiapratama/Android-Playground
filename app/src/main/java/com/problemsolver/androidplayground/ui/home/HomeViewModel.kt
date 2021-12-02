package com.problemsolver.androidplayground.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.androidplayground.data.model.TrendingItem
import com.problemsolver.androidplayground.data.repository.TrendingRepository
import com.problemsolver.androidplayground.data.model.ResultData
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