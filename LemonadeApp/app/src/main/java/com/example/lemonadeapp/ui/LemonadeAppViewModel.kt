package com.example.lemonadeapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.models.DataSource
import com.example.lemonadeapp.models.NUMBER_ITEMS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LemonadeAppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LemonadeAppUiState())

    val uiState: StateFlow<LemonadeAppUiState>
        get() = _uiState.asStateFlow()

    val items = DataSource.loadItems()

    var currentItem = 0
        private set

    var clicks = 0
        private set

    var randomNumber = (0..4).random()

    fun updateItem() {
        _uiState.update {
            currentState ->
            currentState.copy(
                image = items[currentItem].image,
                description =  items[currentItem].description
            )
        }
    }

    fun updateCount() {
        when (currentItem) {
            1 -> {
                    clicks = clicks.inc()
                    if (clicks == randomNumber) {
                        currentItem = (currentItem.inc() % NUMBER_ITEMS)
                        clicks = 0
                        randomNumber = (1..4).random()
                }
            }

            else -> currentItem = (currentItem.inc() % NUMBER_ITEMS)
        }
        updateItem()
    }

    init {
        updateItem()
    }
}