package com.example.savestate.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.savestate.R
import com.example.savestate.data.model.PhoneItem
import kotlinx.android.synthetic.main.banner_item.view.*


class MainAdapter(private val onClick: (PhoneItem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataList: List<PhoneItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        NoPortfolioViewHolder(parent)

    override fun getItemCount(): Int =
        dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NoPortfolioViewHolder -> holder.bind(dataList[position])
        }
    }
}

class NoPortfolioViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
) {
    fun bind(item: PhoneItem) {
        itemView.textName.text = item.name
        itemView.textInformation.text = item.phone
    }
}


