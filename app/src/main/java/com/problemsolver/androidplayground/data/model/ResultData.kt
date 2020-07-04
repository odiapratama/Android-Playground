package com.problemsolver.androidplayground.data.model

sealed class ResultData<out R> {

    data class Success<out T>(val data: T) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()
    object Loading : ResultData<Nothing>()

    fun isLoading(): Boolean {
        return when(this) {
            is Loading -> true
            else -> false
        }
    }

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}