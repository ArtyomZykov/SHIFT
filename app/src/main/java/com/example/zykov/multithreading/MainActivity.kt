package com.example.zykov.multithreading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val timeThread = Thread {
        for (time in 0..1000000) {
            runOnUiThread {
                result_text.text = time.toString()
            }
            Thread.sleep(1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeThread.start()
    }

}