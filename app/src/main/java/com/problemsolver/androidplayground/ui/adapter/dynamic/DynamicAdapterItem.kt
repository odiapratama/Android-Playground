package com.problemsolver.androidplayground.ui.adapter.dynamic

interface DynamicAdapterItem {
    fun id(): Any
    fun content(): Any
    fun payload(data: Any) = DataPayload.None

    interface DataPayload {
        object None: DataPayload
    }
}