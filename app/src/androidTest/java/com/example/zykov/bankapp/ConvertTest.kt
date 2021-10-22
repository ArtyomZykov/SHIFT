package com.example.zykov.bankapp


import android.os.SystemClock.sleep
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.zykov.bankapp.annotation.TestCase
import com.example.zykov.bankapp.screens.ConvertScreen
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
                    goToConvertFragmentButton { click() }
                }
            }

            step("Entering a value in the field rubles") {
                ConvertScreen {
                    editTextView { typeText("1000") }
                    closeSoftKeyboard()
                }
            }

            step("Entering a value in the field rubles") {
                ConvertScreen {
                    textInputLayout { click() }

                    onView(withText("Доллар США"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click())
                }
            }

            step("Checking the conversion result") {
                ConvertScreen {
                    resultTextView {
                        hasText("14.11")
                        isDisplayed()
                    }
                }
            }

        }
    }


}
