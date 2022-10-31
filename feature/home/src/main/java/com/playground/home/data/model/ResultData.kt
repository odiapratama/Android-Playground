package com.playground.home.data.model

import com.playground.core.utils.Status

sealed class ResultData<out R> {

    data class Success<out T>(val data: T) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()
    object Loading : ResultData<Nothing>()

    var status = Status.LOADING
        private set
        get() = when (this) {
            is Loading -> Status.LOADING
            is Success -> Status.SUCCESS
            is Error -> Status.ERROR
        }

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}