package com.example.buildweek_5th_wheel.activity.LandOwner

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.LandListingCreator

import kotlinx.android.synthetic.main.activity_land_owner.*
import kotlinx.android.synthetic.main.content_land_owner.*
import kotlinx.android.synthetic.main.land_owners_list_item.*

class LandOwner : AppCompatActivity(), LandOwnerFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(createLandListing: LandListingCreator) {
        MockData.landListingList.add(createLandListing)
        recycler_view_land_owner.adapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_owner)
        setSupportActionBar(toolbar)

        //OnClick starts LandOwnerFragment
        button_create_listing.setOnClickListener {
            val fragment = LandOwnerFragment()
            fragment.show(supportFragmentManager, "tag")
        }
        recycler_view_land_owner.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_view_land_owner.adapter = LandOwnerRecycler(MockData.landListingList)
        //TODO: make the recycler view keep data when user leaves
        //recycler_view_land_owner.adapter = LandOwnerRecycler(MockData.landListingList)




    }

}
