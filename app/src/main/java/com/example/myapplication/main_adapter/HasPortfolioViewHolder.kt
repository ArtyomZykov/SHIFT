package com.example.myapplication.main_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app_objects.ListItem
import com.example.myapplication.app_objects.StudentItem
import kotlinx.android.synthetic.main.student_item.view.*


class HasPortfolioViewHolder(parent: ViewGroup, private val onClick: (ListItem) -> Unit) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
    ) {

    fun bind(item: ListItem) {
        if (item is StudentItem) {
            itemView.textView.text = item.name + " " + item.secondName
            itemView.textView5.text = item.description
            itemView.imageView2.setOnClickListener { onClick(item) }
        }
    }
}