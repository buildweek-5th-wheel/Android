package com.example.buildweek_5th_wheel

import android.net.Uri
import com.example.buildweek_5th_wheel.model.CreateUser
import com.example.buildweek_5th_wheel.model.LandListingCreator

object MockData {

    //Mock data to fill in for the data we would get from the back end

    var logInList = ArrayList<CreateUser>()

    val userNames = arrayListOf("ilikervs123", "rvsrock321", "rvparkowner123", "ihaveland123", "a")
    val passWords = arrayListOf("password123", "password1234", "password12345", "password123456", "a")
    val LandOwners = arrayListOf(false, false, true, true, false)


    fun createLogInList() {
        for (i in userNames.indices) {
            logInList.add(CreateUser(userNames[i], passWords[i], LandOwners[i]))
        }
    }


    var landListingList = ArrayList<LandListingCreator>()

    val images = mutableListOf(
        "android.resource://com.example.buildweek_5th_wheel/drawable/tree_land",
        "android.resource://com.example.buildweek_5th_wheel/drawable/dirt_land",
        "android.resource://com.example.buildweek_5th_wheel/drawable/cloud_land",
        "android.resource://com.example.buildweek_5th_wheel/drawable/car_land"
    )
    val listingName = mutableListOf(
        "5 feet of land with a tree",
        "Land with dirt in Burley, Idaho",
        "Land with clouds",
        "Great land in Trenton, NJ"
    )

    val landOwnerName = mutableListOf("SoftCamp", "DaddyStoveTop", "DaddyLampShad", "Brick")

    val description = mutableListOf(
        "This is where my mom was born very great land one of my favorites.",
        "I have a lot of dirt and need money please come camp here",
        "look at all the pretty clouds I can talk to the big man upstairs and make sure you see some clouds if you stay here ;)",
        "That's my car its also for sale check it out on my insta"
    )

    fun createLandListing() {
        for (i in images.indices) {
            landListingList.add(
                LandListingCreator(
                    images[i],
                    listingName[i],
                    landOwnerName[i],
                    description[i]
                )
            )
        }
    }


}