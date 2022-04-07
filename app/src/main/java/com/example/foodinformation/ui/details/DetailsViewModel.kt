package com.example.foodinformation.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodinformation.data.model.Food

class DetailsViewModel(food: Food ) : ViewModel() {

    private val _selectedFood = MutableLiveData<Food>()
    val selectedFood: LiveData<Food>
        get() = _selectedFood


    init {
        _selectedFood.value = food
    }



}
