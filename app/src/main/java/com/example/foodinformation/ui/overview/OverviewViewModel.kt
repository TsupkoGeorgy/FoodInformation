package com.example.foodinformation.ui.overview

import android.app.AlertDialog
import android.app.Application
import android.content.DialogInterface
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodinformation.data.model.Food
import com.example.foodinformation.ui.parseJson

class OverviewViewModel(app: Application) : AndroidViewModel(app) {

    private val _foodList =
        MutableLiveData<List<Food>>(parseJson(app.applicationContext, JSON))
    val foodList: LiveData<List<Food>>
        get() = _foodList

    private val _navigateToSelectedFoodDetails = MutableLiveData<Food>()
    val navigateToSelectedFoodDetails: LiveData<Food>
        get() = _navigateToSelectedFoodDetails

    fun displayFoodDetails(food: Food) {
        _navigateToSelectedFoodDetails.value = food
    }

    fun displayFoodDetailsComplete() {
        _navigateToSelectedFoodDetails.value = null
    }

    companion object {
        private const val JSON: String = "food_new.json"
    }


}