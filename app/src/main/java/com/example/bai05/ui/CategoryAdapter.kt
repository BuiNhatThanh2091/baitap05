package com.example.bai05.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bai05.R
import com.example.bai05.model.Category

class CategoryAdapter(private val items: List<Category>) : RecyclerView.Adapter<CategoryAdapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView = itemView.findViewById(R.id.image_cate)
        val tv: TextView = itemView.findViewById(R.id.tvNameCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val c = items[position]
        holder.tv.text = c.name ?: ""
        Glide.with(holder.itemView.context)
            .load(c.images)
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.iv)

        holder.itemView.setOnClickListener {
            // simple click feedback
        }
    }

    override fun getItemCount(): Int = items.size
}

