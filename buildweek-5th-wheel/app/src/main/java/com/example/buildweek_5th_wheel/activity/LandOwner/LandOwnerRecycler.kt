package com.example.buildweek_5th_wheel.activity.LandOwner

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.model.LandListingCreator
import kotlinx.android.synthetic.main.land_owners_list_item.view.*

class LandOwnerRecycler(val data: ArrayList<LandListingCreator>) : RecyclerView.Adapter<LandOwnerRecycler.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflates land_owners_list_item into the RecyclerView
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.land_owners_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        //Adds info from the user to the card view
        holder.image.setImageURI(Uri.parse(data[i].photoLocation))
        holder.title.text = data[i].listingName
        holder.userName.text = "Land Owner: ${data[i].userName}"
        holder.description.text = "Description: ${data[i].description}"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //gets views from the land_owners_list_item
        val image = itemView.land_owners_list_item_image
        val title = itemView.land_owners_list_item_title
        val userName = itemView.land_owners_list_item_user_name
        val description = itemView.land_owners_list_item_desc
    }

}