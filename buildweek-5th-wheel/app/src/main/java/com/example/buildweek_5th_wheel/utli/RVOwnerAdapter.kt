package com.example.buildweek_5th_wheel.utli

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.activity.RVListingDetails
import com.example.buildweek_5th_wheel.model.LandListingCreator
import kotlinx.android.synthetic.main.rv_owners_list_item.view.*

class RVOwnerAdapter(val data: ArrayList<LandListingCreator>) : RecyclerView.Adapter<RVOwnerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_owners_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listImage.setImageURI(data[position].photoLocation)
        holder.listTitle.text = data[position].listingName
        holder.listDesc.text = data[position].description


        holder.listItem.setOnClickListener {
            val intent = Intent(it.context, RVListingDetails::class.java)
            intent.putExtra("key", position)
            startActivity(it.context, intent, null)
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listImage: ImageView = view.rv_owners_list_item_image
        val listTitle: TextView = view.rv_owners_list_item_title
        val listDesc: TextView = view.rv_owners_list_item_desc
        val listItem = view.list_item
    }
}