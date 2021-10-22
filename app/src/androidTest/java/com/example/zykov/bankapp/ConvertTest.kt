package com.example.zykov.bankapp

import androidx.appcompat.widget.AppCompatImageButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.zykov.bankapp.annotation.TestCase
import com.example.zykov.bankapp.screens.ConvertScreen.editTextView
import com.example.zykov.bankapp.screens.MainScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ConvertTest : KTestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @TestCase(name = "Test-2", description = "Checking the correctness of the conversion")
    fun checkCorrectConversion() {
        run {
            step("Tap convert button") {
                MainScreen {
                    goToConvertFragmentButton {
                        click()
                    }
                }
            }
            step("dgs") {
                editTextView {
                    typeText("1000")
                }
            }
        }
    }



}
