package com.maxsch.rxjavalecture

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxsch.rxjavalecture.api.CatsApi
import com.maxsch.rxjavalecture.api.CatsApiImpl
import com.maxsch.rxjavalecture.api.DogsApi
import com.maxsch.rxjavalecture.api.DogsApiImpl
import com.maxsch.rxjavalecture.api.PriceApi
import com.maxsch.rxjavalecture.api.PriceApiImpl
import com.maxsch.rxjavalecture.api.RatsApi
import com.maxsch.rxjavalecture.api.RatsApiImpl
import com.maxsch.rxjavalecture.entities.Animal
import com.maxsch.rxjavalecture.entities.Cat
import com.maxsch.rxjavalecture.entities.Dog
import com.maxsch.rxjavalecture.entities.Rat
import kotlinx.coroutines.*
import kotlinx.coroutines.android.awaitFrame

class MainViewModel(
    private val catsApi: CatsApi = CatsApiImpl(),
    private val dogsApi: DogsApi = DogsApiImpl(),
    private val ratsApi: RatsApi = RatsApiImpl(),
    private val priceApi: PriceApi = PriceApiImpl(),
) : ViewModel() {

    private val _result = MutableLiveData<Map<Animal, Int>>()
    val result: LiveData<Map<Animal, Int>> = _result

    fun getData() {

        try {

            viewModelScope.launch(Dispatchers.IO) {

                var dogsList: List<Dog> = emptyList()
                var catsList: List<Cat> = emptyList()
                var ratsList: List<Rat> = emptyList()

                val dogsJob = async {
                    dogsList = dogsApi.getDogs()
                    Log.i("Test", "getDogs")
                }
                val catsJob = async {
                    catsList = catsApi.getCats()
                    Log.i("Test", "getCats")
                }
                val ratsJob = async {
                    ratsList = ratsApi.getRats()
                    Log.i("Test", "getRats")
                }

                awaitFrame()

                val animalsList: List<Animal> = dogsList + catsList + ratsList
                var animalsPricesMap: Map<Animal, Int> = emptyMap()

                val priceJob = async {
                    for (item in animalsList) {
                        Log.i("Test2", item.toString())
                        animalsPricesMap += mapOf(item to priceApi.getPrice(item))
                    }
                }

                awaitFrame()

                handleAnimalPrices(animalsPricesMap)

            }
        } catch (error: IllegalArgumentException) {
            handleLoadingError(error)
        }
    }

    private fun handleAnimalPrices(animalToPriceMap: Map<Animal, Int>) {
        _result.postValue(animalToPriceMap)
    }

    private fun handleLoadingError(error: IllegalArgumentException) {
        Log.e("MainViewModel", "Failed to load animals and prices", error)
    }
}