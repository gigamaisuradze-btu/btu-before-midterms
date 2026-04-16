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
                var selectedFilter by remember { mutableStateOf<ClothingType?>(null) }
                var clothes by remember { mutableStateOf(Data.clothingItems) }
                var filters by remember { mutableStateOf(Data.filters) }

                NavHost(
                   navController = navController,
                    startDestination = LIST_SCREEN
                ) {
                    composable(
                        route = LIST_SCREEN
                    ) { backStack ->
                        ClothingScreen(
                            filters = filters,
                            clothes = clothes,
                            onItemClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set("clothing_item", it)

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
                        route = "${DETAILS_SCREEN}/{name}"
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






