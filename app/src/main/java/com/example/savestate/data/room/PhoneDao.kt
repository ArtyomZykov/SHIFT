package com.example.savestate.data.room

import androidx.room.*
import com.example.savestate.data.model.PhoneItem
import kotlinx.coroutines.flow.Flow

@Dao
interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(phoneList: PhoneItem)

    @Query("SELECT * FROM phone_table")
    fun loadAllBook() : Flow<List<PhoneItem>>

    @Query("DELETE FROM phone_table")
    fun deleteAll()

    @Delete
    fun delete(phoneItem: PhoneItem)
}