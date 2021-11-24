package com.example.zykov.networkapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://v2.convertapi.com/"

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


