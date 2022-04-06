package com.example.foodinformation.ui.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodinformation.data.model.Food
import com.example.foodinformation.databinding.ListViewItemBinding

class FoodListAdapter() :
    ListAdapter<Food, FoodListAdapter.FoodViewHolder>(DiffCallback)
{
    companion object DiffCallback : DiffUtil.ItemCallback<Food>()
    {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean
        {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean
        {
            return oldItem.id == newItem.id
        }
    }

    class FoodViewHolder(private var binding: ListViewItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
        fun bind(food: Food)
        {
            binding.food = food
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (food: Food) -> Unit)
    {
        fun onClick(food: Food) = clickListener(food)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder
    {
        return FoodViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int)
    {
        val food = getItem(position)
//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(food)
//        }
        holder.bind(food)
    }
}