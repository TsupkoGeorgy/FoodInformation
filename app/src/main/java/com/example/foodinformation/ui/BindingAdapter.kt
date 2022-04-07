package com.example.foodinformation.ui


import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodinformation.data.model.Food
import com.example.foodinformation.ui.overview.FoodListAdapter
import android.R

import android.widget.LinearLayout

import android.webkit.WebView

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Food>?) {
    val adapter = recyclerView.adapter as FoodListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    val context = imgView.context
    val drawableResourceId: Int =
        context.resources.getIdentifier(imgUrl, "drawable", context.packageName)
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(drawableResourceId)
            .into(imgView)
    }
}
