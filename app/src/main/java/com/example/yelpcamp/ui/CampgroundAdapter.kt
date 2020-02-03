package com.example.yelpcamp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yelpcamp.R
import kotlinx.android.synthetic.main.campground_item.view.*

class CampgroundAdapter(var campgrounds: List<Campground>) :
    RecyclerView.Adapter<CampgroundAdapter.CampgroundViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CampgroundViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.campground_item, parent, false)
    )

    override fun getItemCount() = campgrounds.size
    override fun onBindViewHolder(holder: CampgroundViewHolder, position: Int) {
        holder.bind(campgrounds[position])
    }

    class CampgroundViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = itemView.campground_image
        private val title = itemView.campground_title
        fun bind(campground: Campground) {
            title.text = campground.title
            Glide.with(itemView.context).load(campground.imageUrl).into(imageView)
        }
    }
}
