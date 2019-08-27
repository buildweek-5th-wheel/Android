package com.example.buildweek_5th_wheel.activity.LandOwner

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.buildweek_5th_wheel.R

import kotlinx.android.synthetic.main.activity_land_owner.*

class LandOwner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_owner)
        setSupportActionBar(toolbar)

        //OnClick starts LandOwnerFragment
        button_create_listing.setOnClickListener {
            val fragment = LandOwnerFragment()
            fragment.show(supportFragmentManager, "tag")
        }
    }

}
