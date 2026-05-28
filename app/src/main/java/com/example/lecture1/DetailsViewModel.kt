package com.example.lecture1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lecture1.screen.ClothingUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow("Android")
    val uiState: StateFlow<String> = _uiState.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<Navigate>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _sharedFlow.emit(Navigate.NavigateToMainActivity)
        }
    }
}

sealed class Navigate {
    object NavigateToMainActivity: Navigate()
}

data class UiState(
    val isLoading: Boolean = false,
    val ids: List<Int> = listOf(1, 2, 3 ,4)
)