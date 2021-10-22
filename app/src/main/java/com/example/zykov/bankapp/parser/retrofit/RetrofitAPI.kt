package com.example.zykov.bankapp.parser.retrofit

import com.example.zykov.bankapp.models.AppObject
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("daily_json.js")
    suspend fun getCourse(): AppObject
}