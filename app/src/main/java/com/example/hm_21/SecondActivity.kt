package com.example.hm_21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        backButton.setOnClickListener{ emulateBackKeyEvent() }
        toThirdActivityButton.setOnClickListener{ thirdActivityStart() }
    }

    private fun emulateBackKeyEvent() {
        onBackPressed()
    }

    private fun thirdActivityStart() {
        val viewIntent = Intent(this, ThirdActivity::class.java)
        startActivity(viewIntent)
    }
}