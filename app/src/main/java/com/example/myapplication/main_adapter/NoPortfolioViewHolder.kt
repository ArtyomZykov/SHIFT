package com.example.myapplication.main_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app_objects.BannerItem
import com.example.myapplication.app_objects.ListItem
import com.example.myapplication.app_objects.StudentItem
import kotlinx.android.synthetic.main.student_item.view.*


class NoPortfolioViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
) {

    fun bind(item: ListItem) {
        when (item) {
            is StudentItem -> {
                itemView.textView.text = item.name + " " + item.secondName
                itemView.textView5.text = item.description
            }
            is BannerItem -> {
                itemView.textView.text = item.title
                itemView.textView5.text = item.description
            }
        }
    }

}