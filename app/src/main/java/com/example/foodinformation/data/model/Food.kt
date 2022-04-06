package com.example.foodinformation.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("id") @Expose val id: Int?,
    @SerializedName("name") @Expose val name: String?,
    @SerializedName("imgUrl") @Expose val imgUrl: String?,
    @SerializedName("description") @Expose val description: String?
) {
}