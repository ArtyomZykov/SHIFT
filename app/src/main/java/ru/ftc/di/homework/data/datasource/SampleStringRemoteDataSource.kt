package ru.ftc.di.homework.data.datasource

import javax.inject.Inject

class SampleStringRemoteDataSource @Inject constructor() : SampleStringDataSource {

    private val mockedAnswer = "String from remote data source"

    override fun get(): String = mockedAnswer
}