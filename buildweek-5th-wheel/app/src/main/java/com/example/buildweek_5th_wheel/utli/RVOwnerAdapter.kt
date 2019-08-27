package com.example.buildweek_5th_wheel.utli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.buildweek_5th_wheel.R
import com.example.buildweek_5th_wheel.activity.RVListingDetails
import kotlinx.android.synthetic.main.rv_owners_list_item.view.*

class RVOwnerAdapter() : RecyclerView.Adapter<RVOwnerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_owners_list_item,
                parent,
                false
            ) as View
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listImage.setImageResource(R.drawable.ic_launcher_background)
        holder.listTitle.text = "Sample text"
        holder.listDesc.text = "Ben"
        holder.btn.setOnClickListener {
            val intent = Intent(it.context, RVListingDetails::class.java)
            startActivity(it.context, intent, null)
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listImage: ImageView = view.rv_owners_list_item_image
        val listTitle: TextView = view.rv_owners_list_item_title
        val listDesc: TextView = view.rv_owners_list_item_desc
        val btn: Button = view.btn_details

        fun bindModel() {
            listImage.setImageResource(R.drawable.ic_launcher_background)
            listTitle.text = "Sample text"
            listDesc.text =
                "Ben—not his real name, as he wishes to keep his name private a little longer—is a tall, 30-something"

        }
    }
}