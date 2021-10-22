package com.example.zykov.bankapp.screens

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.spinner.KSpinner
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.example.zykov.bankapp.R

object ConvertScreen  : Screen<ConvertScreen>() {

    val editTextView = KEditText { withId(R.id.editTextNumber) }
    val textInputLayout = KButton { withId(R.id.textInputLayout) }
    val resultTextView = KTextView { withId(R.id.resultText) }

}