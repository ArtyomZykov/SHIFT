package com.example.savestate.data.preference


import com.example.savestate.data.model.PhoneItem
import com.example.savestate.domain.Repository
import kotlinx.coroutines.flow.Flow


class RepositoryRepository(override val allNotes: Flow<List<PhoneItem>>) : Repository {
    /**
    override val allNotes: Flow<List<PhoneItem>>
        get() = loadAllBook()

    private fun loadAllBook(): Flow<List<PhoneItem>> {
        return null
    }
    */
}