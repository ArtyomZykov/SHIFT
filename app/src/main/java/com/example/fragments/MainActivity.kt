package com.example.fragments


import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.fragments.service.SortService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.DelicateCoroutinesApi


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        startButton.setOnClickListener { startSortService() }
        stopButton.setOnClickListener { stopSortService() }
    }


    @DelicateCoroutinesApi
    private fun stopSortService() {
        stopService(Intent(this, SortService::class.java))
        resultTextView.text = "SortService was be stopped"
    }

    @DelicateCoroutinesApi
    fun startSortService() {
        startService(Intent(this, SortService::class.java))
        resultTextView.text = "processing"
    }

}

fun printResultArray(array: Array<Int>) {
    val oneToThree = array[0].toString() + "\n" + array[0].toString() + "\n" + array[0].toString()
    APP_ACTIVITY.resultTextView.text = oneToThree
}