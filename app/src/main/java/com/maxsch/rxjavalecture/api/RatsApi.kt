package com.maxsch.rxjavalecture.api

import com.maxsch.rxjavalecture.entities.Rat

interface RatsApi {

    suspend fun getRats(): List<Rat>
}

class RatsApiImpl : RatsApi {

    override suspend fun getRats(): List<Rat> =
        listOf(Rat("Christie", "1"), Rat("Christie2", "12"))

}