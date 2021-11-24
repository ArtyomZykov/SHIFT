package com.example.zykov.networkapp

import android.os.Environment
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zykov.networkapp.retrofit.RetrofitInstance.api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class MainActivityViewModel : ViewModel() {

    fun uploadPng() {
        viewModelScope.launch(Dispatchers.IO) {

            val file = File(Environment.getExternalStorageDirectory().path + "/Download/123.png")
            val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
            val body = MultipartBody.Part.createFormData("image", file.name, requestBody)

            val response = api.postPng(body)
            Log.d("TestServerAnswer", response.toString())

        }

    }

}