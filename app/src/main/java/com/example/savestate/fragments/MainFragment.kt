package com.example.savestate.fragments

import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.savestate.R
import com.example.savestate.database.AppDataBase
import com.example.savestate.database.PhoneItem
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonTop.setOnClickListener { requestData() }
        buttonLoadFromDB.setOnClickListener {
            val database = AppDataBase.getAppDatabase(requireActivity())
            textView.text = database.phoneDao.loadAllBook().toString()
        }
    }

    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
    private var task: Future<Any>? = null

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val granted = grantResults.all { it == PackageManager.PERMISSION_GRANTED }
        if (granted) {
            textView.text = "Granted"
        }
    }

    private fun requestData() {
        task = executor.submit<Any> {
            retrieve()

            activity?.runOnUiThread {
                val database = AppDataBase.getAppDatabase(requireActivity())
                textView.text = database.phoneDao.loadAllBook().toString()
            }
        }
    }

    private fun retrieve() {

        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
        )

        val cursor = activity?.contentResolver?.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        val resultPhoneBookList = mutableListOf<PhoneItem>()
        val DISPLAY_NAME = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        val NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER
        var n: Int = 1
        cursor?.use {
            val nameIndex = cursor.getColumnIndex(DISPLAY_NAME)
            val phoneIndex = cursor.getColumnIndex(NUMBER)

            while (cursor.moveToNext()) {
                val _name = cursor.getString(nameIndex)
                val _phone = cursor.getString(phoneIndex)
                resultPhoneBookList.add(PhoneItem(name = _name, phone = _phone, id = n))
                n++
            }
        }

        val database = AppDataBase.getAppDatabase(requireActivity())
        database.phoneDao.deleteAll()
        database.phoneDao.insert(resultPhoneBookList)

    }


    override fun onDestroy() {
        super.onDestroy()
        task?.cancel(true)
        task = null
    }
}