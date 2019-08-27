package com.example.buildweek_5th_wheel.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.CreateUser
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        //Sends user input to Main Activity on button click if the username and password are not empty
        val userName = username.text.toString()
        val passWord = password.text.toString()
        val isLandOwner = landowner.isChecked

        btn_sign_up.setOnClickListener {

            //adds CreateUser to the list if password and username are filled out then sends user to MainActivity
            if (userName != "" && passWord != "") {
                MockData.logInList.add(CreateUser(userName, passWord, isLandOwner))
                val gotoLogInPage = Intent(this, MainActivity::class.java)
                startActivity(gotoLogInPage)
            }

            //Creates an TextView at the top of the page to let the user know that the haven't add a username/password
            else {
                val invalidInput = TextView(this)
                invalidInput.text = getString(R.string.invalid_registration)
                invalidInput.setTextColor(Color.RED)
                invalidInput.setPadding(8)
                registration_layout.addView(invalidInput, 0)
            }
        }
    }
}
