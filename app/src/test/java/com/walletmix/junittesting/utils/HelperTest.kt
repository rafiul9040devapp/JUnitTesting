package com.walletmix.junittesting.utils

import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    //AAA Format Of Unit Testing

    private lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
    }

    @Test
    fun isOddNumber_input15_expected_TRUE() {
        //AAA Format
        //Act
        val result = helper.isOddNumber(15)
        //Assert
        Assert.assertEquals(true, result)

    }

    @Test
    fun isOddNumber_input8_expected_FALSE() {
        //Act
        val result = helper.isOddNumber(8)
        //Assert
        Assert.assertEquals(false, result)

    }

    @Test
    fun isOddNumber_input_negative69_expected_FALSE() {
        //Act
        val result = helper.isOddNumber(-69)
        //Assert
        Assert.assertEquals(true, result)
    }

    @Test
    fun isOddNumber_input_negative80_expected_FALSE() {
        //Act
        val result = helper.isOddNumber(-80)
        //Assert
        Assert.assertEquals(false, result)
    }

    @After
    fun tearDown(){
        println("Test Is Passed")
    }
}