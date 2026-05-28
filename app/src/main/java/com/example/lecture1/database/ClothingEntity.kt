package com.example.lecture1.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lecture1.model.ClothingItem
import com.example.lecture1.model.ClothingType

@Entity(tableName = "clothes_table")
data class ClothingEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Int,
    val imageUrl: String,
    val isFavorite: Boolean,
    val clothingType: ClothingType
)

fun ClothingEntity.toApiModel(): ClothingItem {
    return ClothingItem(
       id = this.id,
        title = this.title,
        price = this.price,
        imageUrl = this.imageUrl,
        isFavorite = this.isFavorite,
        clothingType = this.clothingType,
    )
}

fun ClothingItem.toDatabase() = ClothingEntity(
    id = this.id,
    title = this.title,
    price = this.price,
    imageUrl = this.imageUrl,
    isFavorite = this.isFavorite,
    clothingType = this.clothingType,
)

