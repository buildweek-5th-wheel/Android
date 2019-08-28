package com.example.buildweek_5th_wheel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import kotlinx.android.synthetic.main.activity_rvlisting_details.*

class RVListingDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_rvlisting_details)

        val landListing = intent.getIntExtra("key", 0)
        val listItem = MockData.landListingList[landListing]

        rv_owners_details_image.setImageURI(listItem.photoLocation)
        rv_owners_details_title.text = listItem.listingName
        rv_owners_details_owner_name.text = listItem.userName
        rv_owners_details_desc.text = listItem.description



    }
}
