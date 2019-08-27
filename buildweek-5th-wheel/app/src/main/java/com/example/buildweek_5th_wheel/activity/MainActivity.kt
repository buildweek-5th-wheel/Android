package com.example.buildweek_5th_wheel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.CreateUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {

    companion object {
        val REGISTER_DATA_KEY = "newKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //List of users that can log in from MockData
        if (MockData.logInList.size == 0){
            MockData.CreateLogInList()
        }

        //Sends the user to the Registration Activity
        val launchRegistrationActivity = Intent(this, RegistrationActivity::class.java)
        register.setOnClickListener {
            startActivity(launchRegistrationActivity)
        }






    }
}
