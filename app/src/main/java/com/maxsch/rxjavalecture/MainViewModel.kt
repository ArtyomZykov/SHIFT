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
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class MainViewModel(
	private val catsApi: CatsApi = CatsApiImpl(),
	private val dogsApi: DogsApi = DogsApiImpl(),
	private val ratsApi: RatsApi = RatsApiImpl(),
	private val priceApi: PriceApi = PriceApiImpl(),
) : ViewModel() {

	private val _result = MutableLiveData<Map<Animal, Int>>()
	val result: LiveData<Map<Animal, Int>> = _result


	private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
		handleLoadingError(throwable)
	}

	fun getData() {
		var dogsList: List<Dog>
		var catsList: List<Cat>
		var ratsList: List<Rat>

		viewModelScope.launch {
			val asyncDogs = async {
				dogsList = dogsApi.getDogs()
				Log.i("Test", "getDogs")
			}
			val asyncCats = async {
				catsList = catsApi.getCats()
				Log.i("Test", "getCats")
			}
			val asyncRats = async {
				ratsList = ratsApi.getRats()
				Log.i("Test", "getRats")
			}

			var animalsList: Animal
			
			if (asyncDogs.isCompleted) {
				dogsList.also { animalsList = it }
			}


		}

	}

	private fun handleAnimalPrices(animalToPriceMap: Map<Animal, Int>) {
		_result.value = animalToPriceMap
	}

	private fun handleLoadingError(error: Throwable) {
		Log.e("MainViewModel", "Failed to load animals and prices", error)
	}
}