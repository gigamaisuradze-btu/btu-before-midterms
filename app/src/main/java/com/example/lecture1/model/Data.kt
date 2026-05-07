package com.example.lecture1.model

import com.example.lecture1.R

object Data {
    val filters = listOf(
        Filter(
            title = "All",
            isSelected = true,
            clothingType = ClothingType.ALL
        ),
        Filter(
            title = "Trousers",
            isSelected = false,
            clothingType = ClothingType.TROUSERS
        ),
        Filter(
            title = "Shirts",
            isSelected = false,
            clothingType = ClothingType.SHIRTS
        ),
        Filter(
            title = "Hoodies",
            isSelected = false,
            clothingType = ClothingType.HOODIES
        ),
        Filter(
            title = "Pants",
            isSelected = false,
            clothingType = ClothingType.PANTS
        ),
        Filter(
            title = "Black Trousers",
            isSelected = false,
            clothingType = ClothingType.TROUSERS
        ),
        Filter(
            title = "Casual Shirts",
            isSelected = false,
            clothingType = ClothingType.SHIRTS
        ),
        Filter(
            title = "Warm Hoodies",
            isSelected = false,
            clothingType = ClothingType.HOODIES
        )
    )
}