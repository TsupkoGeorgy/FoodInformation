package com.example.foodinformation.data.network

import com.example.foodinformation.data.model.Food
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private const val BASE_URL = "src/main/assets/data.json"

private val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FoodApiService {

    fun getProperties(): Call<String>
}

object FoodApi {
    val retrofitService: FoodApiService by lazy { retrofit.create(FoodApiService::class.java) }
}