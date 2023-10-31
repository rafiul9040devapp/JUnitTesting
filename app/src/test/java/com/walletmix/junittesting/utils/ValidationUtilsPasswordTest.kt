package com.walletmix.junittesting.utils

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ValidationUtilsPasswordTest(
    private val password: String,
    private val confirmPassword: String,
    private val expectedResultForPassword: String,
    private val expectedResultForConfirmPassword: String,
) {

    private lateinit var valid: ValidationUtils

    @Before
    fun setUp() {
        valid = ValidationUtils()
    }

    @Test
    fun checkValidPassword() {
        val actualResult = valid.checkValidPassword(password)
        assertEquals(expectedResultForPassword, actualResult)
    }

    @Test
    fun checkConfirmPassword() {
        val actualResult = valid.checkConfirmPassword(password, confirmPassword)
        assertEquals(expectedResultForConfirmPassword, actualResult)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Test Case{index}-> Password: {0}, Confirm Password: {1}, Result: {2}")
        fun data(): List<Array<Any?>> {
            return listOf(
                arrayOf("Abc@1234", "Abc@1234","Minimum 10 Character Password","Password is Matched"),
                arrayOf("Short", "Short", "Minimum 10 Character Password","Password is Matched"),
                arrayOf("NoSpecialChars", "NoSpecialChars", "Must Contain 1 Special Character (@#\$%^&+=)","Password is Matched"),
                arrayOf("Abcdefghij", "Abcdefghij", "Must Contain 1 Special Character (@#\$%^&+=)","Password is Matched"),
                arrayOf("NoLower123", "NoLower123", "Must Contain 1 Special Character (@#\$%^&+=)","Password is Matched"),
                arrayOf("NoUpper@123", "NoUpper@123", "Valid Password","Password is Matched"),
                arrayOf("Short", "Different", "Minimum 10 Character Password","Do not Match"),
                arrayOf("NoUpper@123", "NoUpper@123", "Valid Password","Password is Matched"),
                arrayOf("Short", "Different", "Minimum 10 Character Password","Do not Match"),
                arrayOf("ValidPassword123", "Different","Must Contain 1 Special Character (@#\$%^&+=)", "Do not Match"),
                arrayOf("ValidPassword123", "ValidPassword1234","Must Contain 1 Special Character (@#\$%^&+=)", "Do not Match"),
                arrayOf("    PasswordWith@Space", "PasswordWithSpace", "Valid Password","Do not Match"),
                arrayOf("PasswordWithSpecialChars@", "PasswordWithSpecialChars@", "Valid Password","Password is Matched"),
            )
        }
    }


    @After
    fun tearDown() {
        println("Test Is Passed")
    }

}