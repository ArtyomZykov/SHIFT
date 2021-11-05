package com.example.savestate.data.room

import androidx.annotation.WorkerThread
import com.example.savestate.data.model.PhoneItem
import com.example.savestate.domain.Repository
import kotlinx.coroutines.flow.Flow

class RoomRepository(private val wordDao: PhoneDao) : Repository {

    override val allNotes: Flow<List<PhoneItem>>
        get() = wordDao.loadAllBook()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(item: PhoneItem) {
        wordDao.insert(item)
    }

    fun deleteAll() {
        wordDao.deleteAll()
    }

}