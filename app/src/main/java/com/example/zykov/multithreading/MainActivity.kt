package com.example.zykov.multithreading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val timeThread = Thread {
        for (time in 0..1000000) {
            runOnUiThread {
                if (time > 59) {
                    result_text.text = ((time / 60).toString() +
                            " : " + (time % 60).toString())
                } else result_text.text = time.toString()
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