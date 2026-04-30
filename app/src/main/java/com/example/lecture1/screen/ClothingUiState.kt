package com.example.lecture1.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lecture1.model.ClothingItem
import com.example.lecture1.model.ClothingType
import com.example.lecture1.model.Data
import com.example.lecture1.model.Filter
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ClothingUiState(
    val clothes: List<ClothingItem> = Data.clothingItems,
    val filters: List<Filter> = Data.filters,
) {
    val selectedFilter: Filter? get() = filters.find { it.isSelected }

    val filteredClothes: List<ClothingItem> get() = when (selectedFilter?.clothingType) {
        ClothingType.ALL, null -> clothes
        else -> clothes.filter { it.clothingType == selectedFilter?.clothingType }
    }
}

class ClothingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ClothingUiState())
    val uiState: StateFlow<ClothingUiState> = _uiState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<ClothingItem>()
    val navigationEvent: SharedFlow<ClothingItem> = _navigationEvent.asSharedFlow()

    fun onItemClick(item: ClothingItem) {
        viewModelScope.launch {
            _navigationEvent.emit(item)
        }
    }

    fun onFilterClick(filter: Filter) {
        _uiState.update { current ->
            current.copy(
                filters = current.filters.map {
                    it.copy(isSelected = it == filter)
                }
            )
        }
    }

    fun onFavoriteClick(item: ClothingItem) {
        _uiState.update { current ->
            current.copy(
                clothes = current.clothes.map {
                    if (it == item) it.copy(isFavorite = !it.isFavorite) else it
                }
            )
        }
    }
}