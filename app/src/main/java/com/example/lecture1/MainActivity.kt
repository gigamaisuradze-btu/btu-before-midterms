package com.example.lecture1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lecture1.components.MessageDetail
import com.example.lecture1.model.ClothingItem
import com.example.lecture1.screen.ClothingScreen
import com.example.lecture1.ui.theme.Lecture1Theme
import com.example.lecture1.screen.ClothingViewModel

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Lecture1Theme {
                val navController = rememberNavController()
                val viewModel: ClothingViewModel = viewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                LaunchedEffect(viewModel) {
                    viewModel.navigationEvent.collect { item ->
                        navController.currentBackStackEntry
                            ?.savedStateHandle?.set("clothing_item", item)
                        navController.navigate(DETAILS_SCREEN)
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = LIST_SCREEN
                ) {
                    composable(route = LIST_SCREEN) {
                        ClothingScreen(
                            filters = uiState.filters,
                            clothes = uiState.clothes,
                            isLoading = uiState.isLoading,
                            onItemClick = { viewModel.onItemClick(it) },
                            onFilterClick = { viewModel.onFilterClick(it) },
                            onFavoriteClick = { viewModel.postFavoriteCloth(it.id, !it.isFavorite) }
                        )
                    }

                    composable(route = DETAILS_SCREEN) {
                        val item = navController.previousBackStackEntry
                            ?.savedStateHandle?.get<ClothingItem>("clothing_item")
                        item?.title?.let { MessageDetail(it) }
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