package com.example.buildweek_5th_wheel.activity.LandOwner

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodSession
import androidx.fragment.app.DialogFragment
import com.example.buildweek_5th_wheel.MockData
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.activity.MainActivity
import com.example.buildweek_5th_wheel.model.LandListingCreator
import kotlinx.android.synthetic.main.land_owner_fragment.*

class LandOwnerFragment : DialogFragment() {

    private var image: Uri? = null

    companion object{
        val IMG_REQUEST_CODE = 6
    }

    private var listener : OnFragmentInteractionListener? = null

    override fun onCreateView(
        //Displays land_owner_fragment in the fragment
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.land_owner_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //On click of the image it starts an intent to look for an image
        image_add_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, IMG_REQUEST_CODE)
        }

        ///TODO: add alert if user does not selects and image or puts in text
        //Creates a new listing form the User input
        button_submit_listing.setOnClickListener {
            val listingName = listing_name.text.toString()
            val description = listing_description.text.toString()
            if(image != null){
                visibility_control.visibility = View.GONE
                land_owner_fragment.addView(LoadingScreen(context, null))
                listener?.onFragmentInteraction(LandListingCreator(image.toString(), listingName, MainActivity.userNameFromMain, description))
            }
        }



        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //returns uri of the image user selected
        if (requestCode == IMG_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            image = data?.data
            image_add_image.setImageURI(image)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(createLandListing: LandListingCreator)
    }



}