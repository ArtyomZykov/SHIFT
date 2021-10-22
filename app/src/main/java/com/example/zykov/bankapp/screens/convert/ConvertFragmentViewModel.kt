package com.example.zykov.bankapp.screens.convert

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.zykov.bankapp.models.Items
import kotlin.math.roundToInt

class ConvertFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun getValueByName(name: String, list: List<Items>?): Double {
        if (list != null) {
            list.forEach {
                it.value
                if (it.name == name) {
                    return it.value
                }
            }
        } else {
            IllegalArgumentException("List is NULL")
        }
        throw IllegalArgumentException("Not found name")
    }

    fun converter(amount: Double, rate: Double): Double =
        if (rate != 0.0) {
            ((amount / rate) * 100.0).roundToInt() / 100.0
        } else {
            throw IllegalArgumentException("Div by zero")
        }

}