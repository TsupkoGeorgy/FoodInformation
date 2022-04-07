package com.example.foodinformation.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Food(
    val id: Int?,
    val name: String?,
    val imgUrl: String?,
    val description: String?,
): Parcelable {
}