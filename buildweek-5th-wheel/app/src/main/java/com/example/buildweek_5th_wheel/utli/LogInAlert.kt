package com.example.buildweek_5th_wheel.utli


import android.content.res.Resources
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.buildweek_5th_wheel.R

object LogInAlert {
    fun createAlert(parent: LinearLayout){
        val invalidInput = TextView(parent.context)
        invalidInput.text = Resources.getSystem().getString(R.string.invalid_registration)
        invalidInput.setTextColor(Color.RED)
        invalidInput.setPadding(8)
        parent.addView(invalidInput, 0)
    }
}