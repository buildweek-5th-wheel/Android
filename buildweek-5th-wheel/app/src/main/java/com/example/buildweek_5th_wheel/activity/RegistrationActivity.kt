package com.example.buildweek_5th_wheel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.buildweek_5th_wheel.utli.LogInAlert
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.CreateUser
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        //Sends user input to Main Activity on button click if the username and password are not empty
        btn_sign_up.setOnClickListener {
            val userName = username.text.toString()
            val passWord = password.text.toString()
            val isLandOwner = landowner.isChecked

            //adds CreateUser to the list if password and username are filled out then sends user to MainActivity
            if (userName != "" && passWord != "") {
                MockData.logInList.add(CreateUser(userName, passWord, isLandOwner))
                val gotoLogInPage = Intent(this, MainActivity::class.java)
                startActivity(gotoLogInPage)
            }

            //Creates an TextView at the top of the page to let the user know that the haven't add a username/password
            else LogInAlert.createAlert(main_view_registration, 1)
        }
    }
}
