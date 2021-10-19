package com.example.zykov.bankapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AppObject(
    @SerializedName("Date")
    val date: String,
    @SerializedName("PreviousDate")
    val previousDate: String,
    @SerializedName("PreviousURL")
    val previousURL: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @SerializedName("Valute")
    val currency: Currencies, // Map <String, Items>,
) : Serializable

data class Currencies(
    val AUD: Items = Items(name = "AUD"),
    val AZN: Items = Items(name = "AZN"),
    val GBP: Items = Items(name = "GBP"),
    val AMD: Items = Items(name = "AMD"),
    val BYN: Items = Items(name = "BYN"),
    val BGN: Items = Items(name = "BGN"),
    val BRL: Items = Items(name = "BRL"),
    val HUF: Items = Items(name = "HUF"),
    val HKD: Items = Items(name = "HKD"),
    val DKK: Items = Items(name = "DKK"),
    val USD: Items = Items(name = "USD"),
    val EUR: Items = Items(name = "EUR"),
    val INR: Items = Items(name = "INR"),
    val KZT: Items = Items(name = "KZT"),
    val CAD: Items = Items(name = "CAD"),
    val KGS: Items = Items(name = "KGS"),
    val CNY: Items = Items(name = "CNY"),
    val MDL: Items = Items(name = "MDL"),
    val NOK: Items = Items(name = "NOK"),
    val PLN: Items = Items(name = "PLN"),
    val RON: Items = Items(name = "RON"),
    val XDR: Items = Items(name = "XDR"),
    val SGD: Items = Items(name = "SGD"),
    val TJS: Items = Items(name = "TJS"),
    val TRY: Items = Items(name = "TRY"),
    val TMT: Items = Items(name = "TMT"),
    val UZS: Items = Items(name = "UZS"),
    val UAH: Items = Items(name = "UAH"),
    val CZK: Items = Items(name = "CZK"),
    val SEK: Items = Items(name = "SEK"),
    val CHF: Items = Items(name = "CHF"),
    val ZAR: Items = Items(name = "ZAR"),
    val KRW: Items = Items(name = "KRW"),
    val JPY: Items = Items(name = "JPY"),
) : Serializable {

    var list: List<Items>? = null

    fun setList() {
        list = listOf(AUD, AZN, GBP, AMD, BYN, BGN, BRL, HUF, HKD, DKK, USD, EUR,
            INR, KZT, CAD, KGS, CNY, MDL, NOK, PLN, RON, XDR, SGD, TJS, TRY,
            TMT, UZS, UAH, CZK, SEK, CHF, CHF, ZAR, KRW, JPY)
    }
}

data class Items(
    @SerializedName("ID")
    val id: String = "equals",
    @SerializedName("NumCode")
    val numCode: String = "equals",
    @SerializedName("CharCode")
    val charCode: String  = "equals",
    @SerializedName("Nominal")
    val nominal: Int = 0,
    @SerializedName("Name")
    val name: String  = "equals",
    @SerializedName("Value")
    val value: Double  = 0.0,
    @SerializedName("Previous")
    val previous: Double = 0.0
) : Serializable