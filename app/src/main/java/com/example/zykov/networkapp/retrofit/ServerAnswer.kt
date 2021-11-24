package com.example.zykov.networkapp.retrofit

import com.google.gson.annotations.SerializedName


data class ServerAnswer(
    @SerializedName("FileId")
    val fileId: String,
    @SerializedName("FileName")
    val fileName: String,
    @SerializedName("FileExt")
    val fileExt: String
)
