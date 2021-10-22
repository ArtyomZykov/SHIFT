package com.example.zykov.bankapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.zykov.bankapp.annotation.TestCase
import com.example.zykov.bankapp.screens.MainScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainTest : KTestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @TestCase(name = "Test-1", description = "Check if the list of currencies is displayed")
    fun checkRecyclerViewDisplayed() {
        run {
            step("Check transactions content") {
                checkTransactions(
                    Transaction(name = "Австралийский доллар", currency = "53.1292"),
                    Transaction(name = "Азербайджанский манат", currency = "41.7836"),
                    Transaction(name = "Фунт стерлингов Соединенного королевства", currency = "97.9668"),
                    Transaction(name = "Армянских драмов", currency = "14.864"),
                    Transaction(name = "Белорусский рубль", currency = "29.1685")
                )
            }
        }
    }


    class Transaction(val name: String, val currency: String)

    private fun checkTransactions(vararg transactions: Transaction) {
        transactions.forEachIndexed { index, transaction ->
            MainScreen {
                transactionList {
                    childAt<MainScreen.TransactionItem>(index) {

                        name {
                            isDisplayed()
                            hasText(transaction.name)
                        }

                        currency {
                            isDisplayed()
                            hasText(transaction.currency)
                        }

                    }
                }
            }
        }
    }
}