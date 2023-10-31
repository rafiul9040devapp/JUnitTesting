package com.walletmix.junittesting.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class HelperTestWithParameter(private val inputNumber: Int, private val expectedValue: Boolean) {


    @Test
    fun isOdd() {
        val helper = Helper()
        val result = helper.isOddNumber(inputNumber)
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "Number {0} is ODD: {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf(15, true),
                arrayOf(1, true),
                arrayOf(8, false),
                arrayOf(-33, true),
                arrayOf(-80, false),
            )
        }
    }

}