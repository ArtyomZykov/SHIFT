package com.example.zykov.bankapp.screens

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.example.zykov.bankapp.R

object ConvertScreen  : Screen<ConvertScreen>() {

    val editTextView = KEditText { withId(R.id.editTextNumber) }
    val resultTextView = KTextView { withId(R.id.resultText) }

/*
    val snackbar = KView {
        withId (com.google.android.material.R.id.snackbar_text)
    }
*/
}