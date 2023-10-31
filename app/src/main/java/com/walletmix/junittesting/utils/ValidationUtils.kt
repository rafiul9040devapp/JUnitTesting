package com.walletmix.junittesting.utils;

import android.util.Patterns

class ValidationUtils{

     fun checkValidPassword(password: String): String {

        if(password.length < 10) {
            return "Minimum 10 Character Password"
        }
        if(!password.matches(".*[A-Z].*".toRegex())) {
            return "Must Contain 1 Upper-case Character"
        }
        if(!password.matches(".*[a-z].*".toRegex())) {
            return "Must Contain 1 Lower-case Character"
        }
        if(!password.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }

        return "Valid Password"
    }

     fun checkValidPhoneNumber(contract:String): String? {

        if(!contract.matches(".*[0-9].*".toRegex())){
            return "Must be all Digits"
        }
         if(!contract.startsWith("01")){
             return "Invalid Phone Number"
         }
        if(contract.length != 11){
            return "Must be 11 Digits"
        }
        return null
    }

     fun checkIfEmailIsValid(email: String): String? {

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid Email Address"
        }

        return null
    }

     fun checkUsername(username: String):String{
         val check = username.trim()

        if (check.length<2){
            return "User Name Must Be getter then 2 Letter"
        }
         if (check.length>15){
             return "User Name Must Be less then 15 Letter"
         }

        return "Valid User Name"
    }

    fun checkConfirmPassword(password: String,confirmPassword: String):String{

        if (!(password.equals(confirmPassword))){

            return "Do not Match"
        }

        return "Password is Matched"
    }

    fun checkWebsite(website: String):String?{

        if(Patterns.WEB_URL.matcher(website).matches()){
            return null;
        }else{
            return "Invalid Url"
        }

    }


}