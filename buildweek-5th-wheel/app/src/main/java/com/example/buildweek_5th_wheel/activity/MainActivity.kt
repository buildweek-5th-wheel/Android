package com.example.buildweek_5th_wheel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.activity.LandOwner.LandOwner
import com.example.buildweek_5th_wheel.utli.LogInAlert
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //TODO: add display of RVOwner and LandOwner

    companion object {
        var userNameFromMain = ""
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creates list of Users from the mock data and does it once
        if (MockData.logInList.size == 0){
            MockData.createLogInList()
        }

        //Sends the user to the Registration Activity
        val launchRegistrationActivity = Intent(this, RegistrationActivity::class.java)
        register.setOnClickListener {
            startActivity(launchRegistrationActivity)
        }

        val gotoLandOwner = Intent(this, LandOwner::class.java)
        val gotoRVOwner = Intent(this, RVOwner::class.java)

        //Checks if username and password match the user input and then goes to correct activity
        btn_login.setOnClickListener {
            val userName = username_main.text.toString()
            val passWord = password_main.text.toString()
            var passUser = false
            var isLandOwner: Boolean = false
            if (userName != "" && passWord !="") {
                MockData.logInList.forEach {
                    if (it.userName == userName && it.passWord == passWord) {
                        passUser = true
                        isLandOwner = it.isLandOwner
                    }
                }
                if (passUser){
                    when(isLandOwner){
                        true -> {
                            userNameFromMain = userName
                            startActivity(gotoLandOwner)
                        }// launch land owner activity
                        false -> startActivity(gotoRVOwner) //launch rv activity
                    }
                }
                else LogInAlert.createAlert(login_layout, 1)
            }
            else LogInAlert.createAlert(login_layout, 1)
        }
    }

    //gets rid of alert text if created when a new activity is started
    override fun onStop() {
        super.onStop()
        if (login_layout.getChildAt(1).tag == "displayed"){
            val alertView = login_layout.getChildAt(1) as TextView
            login_layout.removeView(alertView)
        }
    }
}
