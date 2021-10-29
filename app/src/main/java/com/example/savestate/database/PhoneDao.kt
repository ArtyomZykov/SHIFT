package com.example.savestate.database

import androidx.room.*

@Dao
interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(phoneList: List<PhoneItem>)

    @Query("SELECT * FROM phone_table")
    fun loadAllBook() : List<PhoneItem>?

    @Query("DELETE FROM phone_table")
    fun deleteAll(): Int

    @Delete
    suspend fun delete(phoneItem: PhoneItem)
}