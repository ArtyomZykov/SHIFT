package com.example.fragments.service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.printResultArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class SortServiceViewModel: ViewModel() {

    fun sort() {
        viewModelScope.launch(Dispatchers.IO)  {
            val array: Array<Int> = IntArray(20000) { Random().nextInt() }.asList().toTypedArray()
            for (i in array.indices) {
                for (j in 0..array.size - 2) {
                    if (array[j] < array[j + 1]) {
                        val glass = array[j]
                        array[j] = array[j + 1]
                        array[j + 1] = glass
                    }
                }
            }
            viewModelScope.launch(Dispatchers.Main) {
                printResultArray(array)
            }
        }
    }

}