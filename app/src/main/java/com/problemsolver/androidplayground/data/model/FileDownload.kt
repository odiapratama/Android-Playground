package com.problemsolver.androidplayground.data.model

data class FileDownload(
    val id: String,
    val name: String,
    val type: String,
    val url: String,
    var downloadedUri: String? = null,
    val isDownloading: Boolean = false
)
