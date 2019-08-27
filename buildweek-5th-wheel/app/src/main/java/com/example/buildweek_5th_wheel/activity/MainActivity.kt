package com.example.buildweek_5th_wheel.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.CreateUser
import com.example.buildweek_5th_wheel.utli.LogInAlert
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {

    //TODO: add display of RVOwner and LandOwner


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

        /*val imageView = ImageView(this)
        imageView.setImageURI(Uri.parse(MockData.images[0]))
        login_layout.addView(imageView)*/


        //val gotoLandOwner = Intent(this, LandOwner::class.java)
        val gotoRVOwner = Intent(this, RVOwner::class.java)

        btn_login.setOnClickListener {
            val userName = username_main.text.toString()
            val passWord = password_main.text.toString()
            if (userName != "" && passWord !=""){
                MockData.logInList.forEach {
                    if (it.userName == userName && it.passWord == passWord) {
                        when (it.isLandOwner) {
                            //true -> startActivity(gotoLandOwner) // launch land owner activity
                            false -> startActivity(gotoRVOwner) //launch rv activity
                        }
                    }
                    else LogInAlert.createAlert(login_layout) // needs to be fixed displays because the forEach keeps going
                }
            }
            else LogInAlert.createAlert(login_layout)
        }






    }
}
