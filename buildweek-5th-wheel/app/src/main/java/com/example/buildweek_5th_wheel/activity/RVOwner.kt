package com.example.buildweek_5th_wheel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.LandListingCreator

import com.example.buildweek_5th_wheel.utli.RVOwnerAdapter
import kotlinx.android.synthetic.main.activity_rvowners.*


class RVOwner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvowners)

        MockData.createLandListing()

        var mainList = MockData.landListingList

        var searchList = ArrayList<LandListingCreator>()
        searchList.addAll(mainList)

        search_lands.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p1: String?): Boolean {

                if(p1!!.isNotEmpty()){
                    searchList.clear()

                    val search = p1.toLowerCase()
                    mainList.forEach {
                        if(it.listingName.toLowerCase().contains(search)){
                            searchList.add(it)
                        }
                    }


                    rv_owners_recycler_view.adapter?.notifyDataSetChanged()
                }
                else{
                    searchList.clear()
                    searchList.addAll(mainList)
                    rv_owners_recycler_view.adapter?.notifyDataSetChanged()
                }

                return true
            }

        })

        rv_owners_recycler_view.setHasFixedSize(true)
        rv_owners_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_owners_recycler_view.adapter = RVOwnerAdapter(searchList)

    }
}
