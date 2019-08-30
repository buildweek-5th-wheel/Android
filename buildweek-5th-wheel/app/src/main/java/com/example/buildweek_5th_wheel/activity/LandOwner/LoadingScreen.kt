package com.example.buildweek_5th_wheel.activity.LandOwner

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.buildweek_5th_wheel.R

class LoadingScreen (context: Context?, attrs: AttributeSet?): LinearLayout(context, attrs){

    init {
        //adding attributes to the LinearLayout
        gravity = Gravity.CENTER
        orientation = VERTICAL
        setPadding(32,32,32,32)

        //Create the loading image view and then animates it
        val createImage = ImageView(context)
        val loadingIcon = ContextCompat.getDrawable(context!!, R.drawable.loading_animation)
        createImage.setImageDrawable(loadingIcon)
        addView(createImage)
        (loadingIcon as AnimatedVectorDrawable).start()

        //Create text view that says Loading below the loading image
        val loadingText = TextView(context)
        loadingText.apply {
            text = "Loading..."
            textSize = 32f
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            this.setTextColor(Color.BLACK)
        }
        addView(loadingText)




    }

}