package com.example.zykov.multithreading

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ActivityCompat.startActivityForResult

import android.media.AudioManager

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import android.app.PendingIntent



import androidx.core.app.NotificationCompat

import android.app.NotificationChannel
import android.app.TaskStackBuilder
import android.graphics.Color


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        timeThread.start()
    }

    private val timeThread = Thread {
        for (time in 0..1000000) {
            runOnUiThread {
                result_text.text = timeConvert(time)
            }
            Thread.sleep(1000)
        }
    }

    private fun timeConvert(time: Int): String =
        if (time > 59) (time / 60).toString() + " : " + (time % 60).toString()
        else time.toString()

    override fun onStop() {
        startService(Intent(this, NotificationService::class.java))
        super.onStop()
    }

}