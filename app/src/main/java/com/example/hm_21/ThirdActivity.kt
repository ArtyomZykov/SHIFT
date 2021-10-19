package com.example.hm_21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*


class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_third)

        backButton.setOnClickListener{ emulateBackKeyEvent() }
        backToStartButton.setOnClickListener{ firstActivityStart() }
    }

    private fun emulateBackKeyEvent() {
        onBackPressed()
    }

    private fun firstActivityStart() {
        val viewIntent = Intent(this, FirstActivity::class.java)
        viewIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(viewIntent)
    }
}