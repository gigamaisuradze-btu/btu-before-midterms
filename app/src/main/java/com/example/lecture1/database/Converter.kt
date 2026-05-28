package com.example.lecture1.database

import androidx.room.TypeConverter
import com.example.lecture1.model.ClothingType

class Converter {
    @TypeConverter
    fun fromClothingType(value: ClothingType): String = value.name

    @TypeConverter
    fun toClothingType(value: String): ClothingType = ClothingType.valueOf(value.uppercase())
}