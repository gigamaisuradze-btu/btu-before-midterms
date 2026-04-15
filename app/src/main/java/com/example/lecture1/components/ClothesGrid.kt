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
    clothes: List<ClothingItem>,
    onClick: (ClothingItem) -> Unit,
    onFavoriteClick: (ClothingItem) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(clothes) { cloth ->
            ClothingCard(
                clothingItem = cloth ,
                onFavoriteClick = {
                    onFavoriteClick.invoke(cloth)
                },
                onItemClick = {
                    onClick.invoke(cloth)
                }
            )
        }

    }

}