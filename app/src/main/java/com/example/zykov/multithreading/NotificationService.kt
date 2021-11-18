package com.example.zykov.multithreading

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat


class NotificationService : Service() {

    private var idNotification = 0

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        backgroundTimeThread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    private val backgroundTimeThread = Thread {
        for (time in 0..1000000) {
            if (time % 10 == 0 && time != 0)
                sendNotification(time)
            Thread.sleep(1000)
        }
    }

    private fun sendNotification(time: Int) {

        val builder: NotificationCompat.Builder =
            NotificationCompat.Builder(applicationContext, "NotificationService")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Timer")
                .setContentText("App was be closed $time s back")

        val notification = builder.build()

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(idNotification++, notification)

    }

}
