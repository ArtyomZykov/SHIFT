package com.example.myapplication.main_adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.app_objects.BannerItem
import com.example.myapplication.app_objects.ListItem
import com.example.myapplication.app_objects.StudentItem
import java.lang.IllegalArgumentException

class MainAdapter(private val onClick: (ListItem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private companion object {
        const val NO_PORTFOLIO_VIEW_TYPE = 0
        const val HAS_PORTFOLIO_VIEW_TYPE = 1
    }

    var dataList: List<ListItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            NO_PORTFOLIO_VIEW_TYPE -> NoPortfolioViewHolder(parent)
            HAS_PORTFOLIO_VIEW_TYPE -> HasPortfolioViewHolder(parent, onClick)
            else -> throw IllegalArgumentException("Wrong viewType: $viewType")
        }

    override fun getItemCount(): Int =
        dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NoPortfolioViewHolder -> holder.bind(dataList[position])
            is HasPortfolioViewHolder -> holder.bind(dataList[position])
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (val item: ListItem = dataList[position]) {
            is StudentItem -> {
                if (item.hasPortfolio) HAS_PORTFOLIO_VIEW_TYPE
                else NO_PORTFOLIO_VIEW_TYPE
            }
            is BannerItem -> NO_PORTFOLIO_VIEW_TYPE
        }
}