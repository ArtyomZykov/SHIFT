package com.maxsch.rxjavalecture.api

import com.maxsch.rxjavalecture.entities.Cat

interface CatsApi {

	suspend fun getCats(): List<Cat>
}

class CatsApiImpl : CatsApi {

	override suspend fun getCats(): List<Cat> =
				listOf(Cat("John", "10"), Cat("John2", "102"))

}