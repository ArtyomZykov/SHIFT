package com.example.zykov.bankapp.screens.main

import androidx.lifecycle.*
import com.example.zykov.bankapp.models.AppObject
import com.example.zykov.bankapp.parser.retrofit.RetrofitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel(private val repository: RetrofitRepository) : ViewModel() {
    val mResponse: MutableLiveData<AppObject> by lazy {
        MutableLiveData<AppObject>()
    }

    fun getCourse() {
        viewModelScope.launch(Dispatchers.IO) {
            val response: AppObject = repository.getCourse()
            response.currency.setList()
            viewModelScope.launch(Dispatchers.Main) {
                mResponse.value = response
            }
        }
    }
}