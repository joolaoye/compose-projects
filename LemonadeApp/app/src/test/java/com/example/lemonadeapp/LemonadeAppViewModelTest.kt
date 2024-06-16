package com.example.lemonadeapp

import com.example.lemonadeapp.ui.LemonadeAppViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LemonadeAppViewModelTest {
    val lemonadeAppViewModel = LemonadeAppViewModel()

    @Test
    fun LemonadeAppViewModel_updateCount_CountIncremented() {
        val lemonadeAppUiState = lemonadeAppViewModel.uiState

        lemonadeAppViewModel.updateCount()

        val count = lemonadeAppViewModel.currentItem
        val image = lemonadeAppUiState.value.image
        val description = lemonadeAppUiState.value.description


        assertEquals(count, 1)
        assertEquals(image, R.drawable.lemon_squeeze)
        assertEquals(description, R.string.keep_tapping)
    }

    @Test
    fun LemonadeAppViewModel_updateCountWithRandomClicks_CountIncremented() {
        val lemonadeAppUiState = lemonadeAppViewModel.uiState

        lemonadeAppViewModel.updateCount()
        lemonadeAppViewModel.randomNumber = 2

        repeat(2)  {
            lemonadeAppViewModel.updateCount()
        }

        val count = lemonadeAppViewModel.currentItem
        val image = lemonadeAppUiState.value.image
        val description = lemonadeAppUiState.value.description

        assertEquals(count, 2)
        assertEquals(image, R.drawable.lemon_drink)
        assertEquals(description, R.string.tap_lemonade)
    }

    @Test
    fun LemonadeAppViewModel_Initialization_InitialItem() {
        val lemonadeAppUiState = lemonadeAppViewModel.uiState

        val count = lemonadeAppViewModel.currentItem
        val image = lemonadeAppUiState.value.image
        val description = lemonadeAppUiState.value.description

        assertEquals(count, 0)
        assertEquals(image, R.drawable.lemon_tree)
        assertEquals(description, R.string.tap_lemon_tree)
    }
}