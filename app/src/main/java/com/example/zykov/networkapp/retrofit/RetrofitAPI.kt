package com.example.zykov.networkapp.retrofit

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface RetrofitAPI {

    @Multipart
    @POST("upload")
    suspend fun postPng(@Part body: MultipartBody.Part): ServerAnswer

}