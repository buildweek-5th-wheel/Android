package com.example.buildweek_5th_wheel.utli


import android.content.res.Resources
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.buildweek_5th_wheel.R

object LogInAlert {
    fun createAlert(parent: LinearLayout){

        //TODO make the text in the string resources

        //Checks to see if alert is already there if so then it just replaces text instead of creating a new view
        if (parent.getChildAt(0).getTag() == "displayed"){
            val alertView = parent.getChildAt(0) as TextView
            alertView.text = "Please enter a valid username/password"
        }

        else {
            val invalidInput = TextView(parent.context)
            invalidInput.text = "Please enter a valid username/password"
            invalidInput.tag = "displayed"
            invalidInput.setTextColor(Color.RED)
            invalidInput.setPadding(8)
            parent.addView(invalidInput, 0)
        }
    }
}