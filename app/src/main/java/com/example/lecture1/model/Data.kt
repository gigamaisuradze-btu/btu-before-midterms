package com.example.lecture1.model

import com.example.lecture1.R

object Data {
    val filters = mutableListOf(
        Filter(
            title = "All",
            isSelected = true,
            clothingType = ClothingType.ALL
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
            title = "Trousers",
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

    val clothingItems = listOf(
        ClothingItem(
            title = "Classic Black Trousers",
            price = 120,
            image = R.drawable.bitmap,
            isFavorite = true,
            clothingType = ClothingType.TROUSERS
        ),
        ClothingItem(
            title = "Slim Fit White Shirt",
            price = 90,
            image = R.drawable.bitmap,
            isFavorite = false,
            clothingType = ClothingType.SHIRTS
        ),
        ClothingItem(
            title = "Oversized Gray Hoodie",
            price = 150,
            image = R.drawable.bitmap,
            isFavorite = true,
            clothingType = ClothingType.HOODIES
        ),
        ClothingItem(
            title = "Relaxed Blue Pants",
            price = 110,
            image = R.drawable.bitmap,
            isFavorite = false,
            clothingType = ClothingType.PANTS
        ),
        ClothingItem(
            title = "Formal Beige Trousers",
            price = 130,
            image = R.drawable.bitmap,
            isFavorite = false,
            clothingType = ClothingType.TROUSERS
        ),
        ClothingItem(
            title = "Checked Casual Shirt",
            price = 95,
            image = R.drawable.bitmap,
            isFavorite = true,
            clothingType = ClothingType.SHIRTS
        ),
        ClothingItem(
            title = "Zip-Up Black Hoodie",
            price = 160,
            image = R.drawable.bitmap,
            isFavorite = false,
            clothingType = ClothingType.HOODIES
        )
    )
}
