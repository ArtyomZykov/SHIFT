package com.example.savestate.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PhoneItem::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract val phoneDao: PhoneDao

    companion object {
        private var instance: AppDataBase? = null

        fun getAppDatabase(context: Context): AppDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "phone_table"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as AppDataBase
        }
    }
}