package com.devdin.factsnews.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.devdin.factsnews.R
import com.devdin.factsnews.datamodel.FNFactResponseRow

class FNRecyclerAdapter(response: List<FNFactResponseRow>, context: Context) :
    RecyclerView.Adapter<FNRecyclerAdapter.DataViewHolder>() {

    private var newsList = response
    private var context: Context? = context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(
            R.layout.list_item_template,
            parent, false
        )
        return DataViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList?.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.title.text = currentItem?.title
        holder.description.text = currentItem?.description
            Glide.with(context!!).load(currentItem.imageHref?.replace("http", "https")).apply(
                RequestOptions().diskCacheStrategy(
                    DiskCacheStrategy.ALL
                )).into(holder.imgView)
    }

    /**
     * View Holder design pattern Implementation
     */
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare properties
        var title = itemView.findViewById<TextView>(R.id.itemTitleTextView)!!
        var description = itemView.findViewById<TextView>(R.id.itemBodyTextView)!!
        var imgView: ImageView = itemView.findViewById<ImageView>(R.id.itemPhotoImageView)!!
    }
}