package com.example.foodinformation.ui.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodinformation.data.model.Food
import com.example.foodinformation.ui.overview.OverviewViewModel

class DetailsViewModelFactory (
    private val food: Food
    ) : ViewModelProvider.Factory  {

        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T
        {
            if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
                return DetailsViewModel(food) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }