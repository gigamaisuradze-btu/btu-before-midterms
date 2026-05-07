package com.example.lecture1.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClothingItem(
    val id: Int,
    val title: String,
    val price: Int,
    val imageUrl: String,
    val isFavorite: Boolean,
    val clothingType: ClothingType
) : Parcelable

@Parcelize
enum class ClothingType : Parcelable {
    TROUSERS,
    ALL,
    SHIRTS,
    HOODIES,
    PANTS
}

data class Filter(
    val title: String,
    val isSelected: Boolean,
    val clothingType: ClothingType
)
