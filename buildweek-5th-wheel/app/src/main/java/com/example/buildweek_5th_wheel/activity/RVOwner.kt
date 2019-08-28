package com.example.buildweek_5th_wheel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R

import com.example.buildweek_5th_wheel.utli.RVOwnerAdapter
import kotlinx.android.synthetic.main.activity_rvowners.*


class RVOwner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvowners)

        MockData.createLandListing()

        rv_owners_recycler_view.setHasFixedSize(true)
        rv_owners_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_owners_recycler_view.adapter = RVOwnerAdapter(MockData.landListingList)

    }
}
