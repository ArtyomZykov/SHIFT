package com.maxsch.rxjavalecture.api

import com.maxsch.rxjavalecture.entities.Dog


interface DogsApi {

    suspend fun getDogs(): List<Dog>
}

class DogsApiImpl : DogsApi {

    override suspend fun getDogs(): List<Dog> =
        listOf(Dog("Michel", "4"), Dog("Michel2", "42"))

}