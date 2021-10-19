package com.example.zykov.bankapp

import android.app.Application
import com.example.zykov.bankapp.models.Items
import com.example.zykov.bankapp.screens.convert.ConvertFragmentViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.runners.Parameterized
import org.mockito.kotlin.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ConvertFragmentViewModelUnitTest {

    companion object {
        @JvmStatic
        var list: List<Items> = listOf(
            Items(name = "ones", value = 1.0),
            Items(name = "two", value = 2.0),
            Items(name = "onesss", value = 1.0),
            Items(name = "one", value = 1.5),
            Items(name = "one", value = 6.0),
            Items(name = "1", value = 5.0)
        )
        var nullList: List<Items>? = null
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Checking to throw an exception if it is NOT FIND VALUE in the LIST`() {
        val app: Application = mock()
        val viewModelConverter = ConvertFragmentViewModel(app)

        viewModelConverter.getValueByName("OONNEE", list)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Checking to throw an exception when the list is empty`() {
        val app: Application = mock()
        val viewModelConverter = ConvertFragmentViewModel(app)

        viewModelConverter.getValueByName("one", nullList)
    }

    @Test
    fun `Checking for the first occurrence when selecting`() {
        val app: Application = mock()
        val viewModelConverter = ConvertFragmentViewModel(app)

        val actual = viewModelConverter.getValueByName("one", list)
        val expected = 1.5

        assertEquals(expected, actual, 0.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `WHEN division by zero throw an EXEPTION IllegalArgumentException`() {
        val app: Application = mock()
        val viewModelConverter = ConvertFragmentViewModel(app)

        viewModelConverter.converter(99.0, 0.0)
    }

    @Test
    fun `Checking rounding up to hundredths`() {
        val app: Application = mock()
        val viewModelConverter = ConvertFragmentViewModel(app)

        val actual = viewModelConverter.converter(99.0, 16.0)
        val expected = 6.19

        assertEquals(expected, actual, 0.0)
    }

    @Test
    fun `Drop check without rounding to hundredths`() {
        val app: Application = mock()
        val viewModelConverter = ConvertFragmentViewModel(app)

        val actual = viewModelConverter.converter(85.0, 7.0)
        val expected = 12.14

        assertEquals(expected, actual, 0.0)
    }
}