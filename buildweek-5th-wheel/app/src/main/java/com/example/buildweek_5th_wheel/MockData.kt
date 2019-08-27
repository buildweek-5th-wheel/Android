package com.example.buildweek_5th_wheel

import com.example.buildweek_5th_wheel.model.CreateUser

object MockData {

    var logInList = ArrayList<CreateUser>()

    val userNames = arrayListOf("ilikervs123", "rvsrock321", "rvparkowner123", "ihaveland123")
    val passWords = arrayListOf("password123", "password1234", "password12345", "password123456")
    val LandOwners = arrayListOf(false, false, true, true)


    fun CreateLogInList(){
        for (i in userNames.indices){
            MockData.logInList.add(CreateUser(userNames[i], passWords[i], LandOwners[i]))
        }
    }


}