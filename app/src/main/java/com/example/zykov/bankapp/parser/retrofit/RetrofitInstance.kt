package com.example.zykov.bankapp.parser.retrofit

import com.example.zykov.bankapp.utilites.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RetrofitAPI by lazy {
        retrofit.create(RetrofitAPI::class.java)
    }
}