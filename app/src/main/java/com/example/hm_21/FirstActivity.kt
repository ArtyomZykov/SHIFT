package com.example.hm_21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)

        backButton.setOnClickListener{ emulateBackKeyEvent() }
        toSecondActivityButton.setOnClickListener{ secondActivityStart() }
    }

    private fun emulateBackKeyEvent() {
        onBackPressed()
    }

    private fun secondActivityStart() {
        val viewIntent = Intent(this, SecondActivity::class.java)
        startActivity(viewIntent)
    }
}