package com.example.buildweek_5th_wheel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.CreateUser
import com.example.buildweek_5th_wheel.utli.LogInAlert
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creates list of Users from the mock data and does it once
        if (MockData.logInList.size == 0){
            MockData.CreateLogInList()
        }

        //Sends the user to the Registration Activity
        val launchRegistrationActivity = Intent(this, RegistrationActivity::class.java)
        register.setOnClickListener {
            startActivity(launchRegistrationActivity)
        }

        val userName = username_main.text.toString()
        val passWord = password_main.text.toString()
        MockData.logInList.forEach {
            if (it.userName == userName && it.passWord == passWord){
                when(it.isLandOwner){
                    true -> 0/// launch L.O activity
                    false -> 0// rv activity
                }
            }
            else LogInAlert.createAlert(login_layout)
        }






    }
}
