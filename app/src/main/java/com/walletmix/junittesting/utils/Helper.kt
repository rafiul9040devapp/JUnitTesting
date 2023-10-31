package com.walletmix.junittesting.utils

import kotlin.math.abs

class Helper {
   //    fun isOddNumber(input: Int): Boolean = input % 2 == 1
  //  fun isOddNumber(input: Int): Boolean = input % 2 != 0

    fun isOddNumber(input: Int): Boolean = abs(input) % 2 == 1

}