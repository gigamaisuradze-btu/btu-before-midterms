package com.example.lecture1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lecture1.model.ClothingItem

@Composable
fun ClothesGrid(
    clothes: List<ClothingItem>?,
    isLoading: Boolean = false,
    onFavoriteClick: (ClothingItem) -> Unit,
    onClick: (ClothingItem) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (isLoading) {
            items(6) {
                ClothingCard(
                    isLoading = true,
                    clothingItem = null,
                    onFavoriteClick = {},
                    onItemClick = {}
                )
            }
        } else {
            items(clothes.orEmpty()) { item ->
                ClothingCard(
                    isLoading = false,
                    clothingItem = item,
                    onFavoriteClick = { onFavoriteClick.invoke(item) },
                    onItemClick = { onClick.invoke(item) }
                )
            }
        }
    }
}