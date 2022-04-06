package com.example.foodinformation.ui

import android.content.Context
import com.example.foodinformation.data.model.Food
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun parseJson(context: Context, fileName: String): List<Food>  {
    val jsonFileString = getJsonDataFromAsset(context, fileName)
    val gson = Gson()
    val listPersonType = object : TypeToken<List<Food>>() {}.type
    return gson.fromJson(jsonFileString, listPersonType)
}