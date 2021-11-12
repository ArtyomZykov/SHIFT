package ru.ftc.di.homework.domain.repository

interface SampleStringRepository {

    fun getFromRemote(): String

    fun getFromLocal(): String

}