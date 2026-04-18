package com.example.lecture1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lecture1.components.MessageDetail
import com.example.lecture1.components.MessageListScreen
import com.example.lecture1.model.ClothingItem
import com.example.lecture1.model.ClothingType
import com.example.lecture1.model.Data
import com.example.lecture1.screen.ClothingScreen
import com.example.lecture1.ui.theme.Lecture1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Lecture1Theme {
                val navController = rememberNavController()
                var clothes by remember { mutableStateOf(Data.clothingItems) }
                var filters by remember { mutableStateOf(Data.filters) }
                val selectedFilter = filters.find { it.isSelected }

                val filteredClothes = clothes.filter { item ->
                    item.clothingType == selectedFilter?.clothingType
                }

                val items = when {
                    selectedFilter?.clothingType == ClothingType.ALL -> clothes
                    else -> {filteredClothes}
                }

                NavHost(
                   navController = navController,
                    startDestination = LIST_SCREEN
                ) {
                    composable(
                        route = LIST_SCREEN
                    ) { backStack ->
                        ClothingScreen(
                            filters = filters,
                            clothes = items,
                            onItemClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set("clothing_item", it)
                                navController.navigate(DETAILS_SCREEN)
                            },
                            onFilterClick = {
                                filters = filters.map { currentFilter ->
                                    if (currentFilter == it) {
                                        currentFilter.copy(isSelected = true)
                                    } else {
                                        currentFilter.copy(isSelected = false)
                                    }
                                }
                            },
                            onFavoriteClick = {
                                clothes = clothes.map { currentItem ->
                                    if (currentItem == it) {
                                        currentItem.copy(isFavorite = !currentItem.isFavorite)
                                    } else {
                                        currentItem
                                    }
                                }
                            }
                        )
                    }

                    composable(
                        route = "${DETAILS_SCREEN}"
                    ) { backStack ->
                        val item = navController.previousBackStackEntry?.savedStateHandle?.get<ClothingItem>("clothing_item")

                        item?.title?.let {
                            MessageDetail(it)
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val LIST_SCREEN = "LIST_SCREEN"
        const val DETAILS_SCREEN = "DETAILS_SCREEN"
    }
}






