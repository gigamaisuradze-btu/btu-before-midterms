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
import com.example.lecture1.model.ClothingType
import com.example.lecture1.model.Data
import com.example.lecture1.model.Filter
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
                val filteredClothes = remember(clothes, filters) {
                    if (selectedFilter?.clothingType == ClothingType.ALL || selectedFilter == null) {
                        clothes
                    } else {
                        clothes.filter { it.clothingType == selectedFilter.clothingType }
                    }
                }

                NavHost(
                   navController = navController,
                    startDestination = LIST_SCREEN
                ) {
                    composable(
                        route = LIST_SCREEN
                    ) { _ ->
                        ClothingScreen(
                            filters = filters,
                            clothes = filteredClothes,
                            onFilterClick = { clickedFilter ->
                                filters = filters.map { filter ->
                                    if (filter == clickedFilter) {
                                        filter.copy(isSelected = true)
                                    } else {
                                        filter.copy(isSelected = false)
                                    }
                                }.toMutableList()
                            },
                            onItemClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set("clothing_item", it)
                                navController.navigate(DETAILS_SCREEN)
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
                        val name = backStack.arguments?.getString("name") ?: ""

                        MessageDetail(name)
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






