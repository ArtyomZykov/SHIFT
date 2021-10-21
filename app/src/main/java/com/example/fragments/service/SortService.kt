package com.example.fragments.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.DelicateCoroutinesApi


@DelicateCoroutinesApi
class SortService : Service() {

    private val sortServiceViewModel = SortServiceViewModel()

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (flags and START_FLAG_RETRY == 0) {
            // Если это повторный запуск
            sortServiceViewModel.sort()
        } else {
            sortServiceViewModel.sort()
        }
        return super.onStartCommand(intent, flags, startId)
    }
}