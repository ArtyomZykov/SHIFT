package com.example.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private companion object {
        const val REQUEST_CODE = 3184
    }

    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    private var task: Future<Any>? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getPermissionButton.setOnClickListener { checkPermission() }
        setResultButton.setOnClickListener { requestData() }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkPermission() {
        if (isPermissionGranted()) {
            resultTextView.text = "Granted"
        } else {
            requestPermission()
        }
    }

    private fun isPermissionGranted(): Boolean =
        PackageManager.PERMISSION_GRANTED ==
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                )


    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestPermission() {
        requestPermissions(
            arrayOf(Manifest.permission.READ_CONTACTS),
            REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val granted = grantResults.all { it == PackageManager.PERMISSION_GRANTED }
        if (granted) { resultTextView.text = "Granted" }
    }

    private fun requestData() {
        task = executor.submit<Any> {
            val result = try {
                retrieveImageNames()

            } catch (error: Throwable) {
                error.localizedMessage
            }

            runOnUiThread {
                resultTextView.text = result
            }
        }
    }


    private fun retrieveImageNames(): String {
        val uri = Uri.parse("content://com.android.contacts/contacts")

        val projection = arrayOf(
            ContactsContract.Profile._ID,
            ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
        )

        val cursor = contentResolver.query(
            uri,
            projection,
            null,
            null,
            null
        )

        val names = mutableListOf<String>()
        val DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME

        cursor?.use {
            val index = cursor.getColumnIndex(DISPLAY_NAME)
            while (cursor.moveToNext()) {
                val name = cursor.getString(index)
                names.add(name)
            }
        }

        return names.joinToString("\n")
    }

    override fun onDestroy() {
        super.onDestroy()
        task?.cancel(true)
        task = null
    }
}