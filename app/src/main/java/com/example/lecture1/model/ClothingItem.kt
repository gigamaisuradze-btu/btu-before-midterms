package com.example.lecture1.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

data class ClothingItem(
    val title: String,
    val price: Int,
    @DrawableRes val image: Int,
    val isFavorite: Boolean,
    val clothingType: ClothingType
)

enum class ClothingType {
    TROUSERS,
    SHIRTS,
    HOODIES,
    PANTS
}

data class Filter(
    val title: String,
    val isSelected: Boolean,
    val clothingType: ClothingType
)
