package com.example.lecture1.screen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lecture1.model.ClothingItem
import com.example.lecture1.model.ClothingType
import com.example.lecture1.model.Data
import com.example.lecture1.model.Filter
import com.example.lecture1.network.ClothingRepository
import com.example.lecture1.network.NetworkResult
import com.example.lecture1.network.RetrofitClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ClothingUiState(
    val clothes: List<ClothingItem> = emptyList(),
    val filters: List<Filter> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
) {
    val selectedFilter: Filter? = filters.find { it.isSelected }

    val filteredClothes: List<ClothingItem> get() = when (selectedFilter?.clothingType) {
        ClothingType.ALL, null -> clothes
        else -> clothes.filter { it.clothingType == selectedFilter?.clothingType }
    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class ClothingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ClothingUiState())
    val uiState: StateFlow<ClothingUiState> = _uiState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<ClothingItem>()
    val navigationEvent: SharedFlow<ClothingItem> = _navigationEvent.asSharedFlow()

    private val clothingRepository = ClothingRepository()

    init {
        fetchClothes()
    }

    fun postFavoriteCloth(id: Int) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            when (val result = clothingRepository.postClothFavorite(id)) {
                is NetworkResult.Success -> {
                    fetchClothes()
                }

                is NetworkResult.Failure -> {

                }
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun fetchClothes() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            when (val result = clothingRepository.getClothes()) {
                is NetworkResult.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            filters = Data.filters,
                            clothes = result.data
                        )
                    }
                }

                is NetworkResult.Failure -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = result.message
                        )
                    }
                }
            }
        }
    }

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