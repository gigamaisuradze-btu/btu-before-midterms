package com.example.lecture1.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.lecture1.components.ClothesGrid
import com.example.lecture1.components.FiltersList
import com.example.lecture1.model.ClothingItem
import com.example.lecture1.model.Filter

@Composable
fun ClothingScreen(
    filters: List<Filter>,
    clothes: List<ClothingItem>,
    onFavoriteClick: (ClothingItem) -> Unit,
    onFilterClick: (Filter) -> Unit,
    onItemClick: (ClothingItem) -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            FiltersList(
                filters
            ) {
                onFilterClick.invoke(it)
            }

            Spacer(modifier = Modifier.height(12.dp))

            ClothesGrid(
                clothes = clothes,
                onClick = { onItemClick.invoke(it) },
                onFavoriteClick = { onFavoriteClick.invoke(it) }
            )
        }
    }
}