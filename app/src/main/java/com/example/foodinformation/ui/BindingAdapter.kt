package com.example.foodinformation.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodinformation.data.model.Food
import com.example.foodinformation.ui.overview.FoodListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Food>?) {
    val adapter = recyclerView.adapter as FoodListAdapter
    adapter.submitList(data)
}
