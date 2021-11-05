package com.example.savestate.domain

import com.example.savestate.data.model.PhoneItem
import kotlinx.coroutines.flow.Flow

interface Repository {

    val allNotes: Flow<List<PhoneItem>>

}