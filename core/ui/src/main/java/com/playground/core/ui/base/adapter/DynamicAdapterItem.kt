package com.playground.core.ui.base.adapter

interface DynamicAdapterItem {
    fun id(): Any
    fun content(): Any
    fun payload(data: Any) = DataPayload.None

    interface DataPayload {
        object None: DataPayload
    }
}