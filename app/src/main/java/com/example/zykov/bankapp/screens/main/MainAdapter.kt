package com.example.zykov.bankapp.screens.main

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zykov.bankapp.R
import com.example.zykov.bankapp.models.Items
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private var mListNotes = emptyList<Items>()

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName: TextView = view.item_name
        val textValue: TextView = view.item_value
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textValue.text = mListNotes[position].value.toString()
        holder.textName.text = mListNotes[position].name
    }

    override fun getItemCount(): Int {
        return mListNotes.size
    }

    fun setList(list: List<Items>) {
        mListNotes = list
        notifyDataSetChanged()
    }
}