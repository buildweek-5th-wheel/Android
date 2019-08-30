package com.example.buildweek_5th_wheel.utli


import android.content.res.Resources
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.core.view.setPadding
import com.example.buildweek_5th_wheel.R

object LogInAlert {
    fun createAlert(parent: LinearLayout, childLocation: Int = 0){

        //alerts the user if they did something that they shouldn't

        //Checks to see if alert is already there if so then it just replaces text instead of creating a new view
        if (parent.getChildAt(childLocation).tag == "displayed"){
            val alertView = parent.getChildAt(childLocation) as TextView
            alertView.text = "Please enter a valid username/password"
        }

        else {
            val invalidInput = TextView(parent.context)
            invalidInput.text = "Please enter a valid username/password"
            invalidInput.tag = "displayed"
            invalidInput.setTextColor(Color.RED)
            invalidInput.setPadding(8)
            parent.addView(invalidInput, childLocation)
        }
    }
}