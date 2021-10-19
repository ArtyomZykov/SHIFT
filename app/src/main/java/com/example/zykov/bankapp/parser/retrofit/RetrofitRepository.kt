package com.example.zykov.bankapp.parser.retrofit

import com.example.zykov.bankapp.models.AppObject

class RetrofitRepository {
    suspend fun getCourse(): AppObject {
        return RetrofitInstance.api.getCourse()
    }
}