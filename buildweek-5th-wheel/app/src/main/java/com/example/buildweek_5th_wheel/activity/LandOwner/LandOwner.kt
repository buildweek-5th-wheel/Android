package com.example.buildweek_5th_wheel.activity.LandOwner

import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.LandListingCreator

import kotlinx.android.synthetic.main.activity_land_owner.*
import kotlinx.android.synthetic.main.content_land_owner.*
import kotlinx.android.synthetic.main.land_owner_fragment.*
import kotlinx.android.synthetic.main.land_owners_list_item.*

class LandOwner : AppCompatActivity(), LandOwnerFragment.OnFragmentInteractionListener{
    val fragment = LandOwnerFragment()

    override fun onFragmentInteraction(createLandListing: LandListingCreator) {
        //When you interact with the fragment, the LandListingCreator created is added to the array of the ladder.
        //Then notifies the RecyclerView that it needs to display the new LandListingCreator
        MockData.landListingList.add(createLandListing)
        recycler_view_land_owner.adapter?.notifyDataSetChanged()

        //Delays the dismissing the LandOwnerFragment by 2 seconds
        val handler = Handler()
        handler.postDelayed({fragment.dismiss()}, 2000)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_owner)
        setSupportActionBar(toolbar)

        //OnClick starts LandOwnerFragment
        button_create_listing.setOnClickListener {
            fragment.show(supportFragmentManager, "tag")
        }

        //Display RecyclerView inflating an array of LandListingCreator
        recycler_view_land_owner.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_view_land_owner.adapter = LandOwnerRecycler(MockData.landListingList)
    }

}
