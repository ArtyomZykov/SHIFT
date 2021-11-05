package com.example.savestate.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.savestate.data.model.PhoneItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [PhoneItem::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getAppRoomDao(): PhoneDao

    companion object {
        @Volatile
        private var database: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            return if (database == null) {
                database = Room.databaseBuilder(context, AppDataBase::class.java, "database").build()
                database as AppDataBase
            } else database as AppDataBase
        }
    }
}