package com.example.buildweek_5th_wheel.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.LandListingCreator
import kotlinx.android.synthetic.main.activity_rvlisting_details.*
import java.io.Serializable

class RVListingDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvlisting_details)

        val landListing = intent.getSerializableExtra("key") as LandListingCreator

        rv_owners_details_image.setImageURI(Uri.parse(landListing.photoLocation))
        rv_owners_details_title.text = landListing.listingName
        rv_owners_details_owner_name.text = landListing.userName
        rv_owners_details_desc.text = landListing.description



    }
}
