package com.example.savestate.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.savestate.R
import com.example.savestate.data.model.PhoneItem
import com.example.savestate.data.room.AppDataBase
import com.example.savestate.data.room.RoomRepository
import com.example.savestate.presentation.MainFragmentModelFactory
import com.example.savestate.presentation.MainFragmentViewModel
import com.example.savestate.ui.MainAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainFragment : Fragment() {

    private val viewModel: MainFragmentViewModel by viewModels {
        MainFragmentModelFactory(RoomRepository(AppDataBase.getInstance(requireActivity().applicationContext).getAppRoomDao()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun insertToDb() {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        viewModel.insert(PhoneItem(name = "first", phone = currentDate))
    }

    private fun deleteFromData() {
        viewModel.deleteAll()
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        viewModel.allNotes.observe(this) { notes ->
            notes.let {
                recycler_view?.apply {
                    val mainAdapter = MainAdapter(onClick = {
                        Toast.makeText(context, "clicked on $it", Toast.LENGTH_SHORT).show()
                    })
                    mainAdapter.dataList = it
                    adapter = mainAdapter
                }
            }
        }
        deleteButton.setOnClickListener { deleteFromData() }
        insertButton.setOnClickListener { insertToDb() }
    }

}