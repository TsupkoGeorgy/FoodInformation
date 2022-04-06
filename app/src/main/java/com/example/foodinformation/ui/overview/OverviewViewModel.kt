package com.example.foodinformation.ui.overview

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodinformation.data.model.Food
import com.example.foodinformation.data.network.FoodApi
import com.example.foodinformation.ui.getJsonDataFromAsset
import com.example.foodinformation.ui.parseJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.FileReader
import java.io.IOException

class OverviewViewModel(app: Application) : AndroidViewModel(app) {

    private val _foodList = MutableLiveData<List<Food>>()
    val foodList: LiveData<List<Food>>
        get() = _foodList


    init
    {
        _foodList.value = parseJson(app.applicationContext, "food_new.json")
    }


}