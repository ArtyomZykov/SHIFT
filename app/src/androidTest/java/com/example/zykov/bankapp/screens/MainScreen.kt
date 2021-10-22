package com.example.zykov.bankapp.screens

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.example.zykov.bankapp.R
import org.hamcrest.Matcher

object MainScreen  : Screen<MainScreen>() {

    val goToConvertFragmentButton = KButton { withId(R.id.btn_converter) }

    val transactionList = KRecyclerView(
        builder = { withId(R.id.recycler_view) },
        itemTypeBuilder = { itemType(::TransactionItem) }
    )

    class TransactionItem(parent: Matcher<View>) : KRecyclerItem<TransactionItem>(parent) {

        val name = KTextView(parent) { withId(R.id.item_name) }
        val currency = KTextView(parent) { withId(R.id.item_value) }
    }
}