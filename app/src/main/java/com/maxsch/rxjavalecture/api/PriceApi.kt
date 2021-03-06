package com.maxsch.rxjavalecture.api

import com.maxsch.rxjavalecture.entities.Animal
import com.maxsch.rxjavalecture.entities.Cat
import com.maxsch.rxjavalecture.entities.Dog
import com.maxsch.rxjavalecture.entities.Rat

interface PriceApi {

	suspend fun getPrice(animal: Animal): Int
}

class PriceApiImpl : PriceApi {

	override suspend fun getPrice(animal: Animal): Int {
		val value = when (animal) {
			is Cat -> 1
			is Dog -> 2
			is Rat -> 3
			else   -> throw IllegalArgumentException("Unknown animal")
		}
		return value
	}
}