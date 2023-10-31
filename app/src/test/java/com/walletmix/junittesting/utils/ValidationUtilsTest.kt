package com.walletmix.junittesting.utils

import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ValidationUtilsTest(private val value: String, private val expectedValue:String) {

    @Test
    fun checkUsername() {
        val valid = ValidationUtils()
        val result = valid.checkUsername(value)
        assertEquals(expectedValue,result)
    }

    companion object{
        @JvmStatic
        @Parameters(name = "Index[{index}]: User Name {0} is {1}")
        fun data():List<Array<Any>> {
            return listOf(
                arrayOf("21","Valid User Name"),
                arrayOf("90450","Valid User Name"),
                arrayOf("2","User Name Must Be getter then 2 Letter"),
                arrayOf("Asad904","Valid User Name"),
                arrayOf("sdffdjshdsjfhsadjfh","User Name Must Be less then 15 Letter"),
            )
        }
    }
}