package com.example.artspaceapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import org.junit.Rule
import org.junit.Test


class ArtSpaceUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_previous_button() {
        composeTestRule.setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }

        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithText("Leaning Tower of Pisa")
            .assertExists("Something is wrong with the previous button")
    }

    @Test
    fun test_next_button() {
        composeTestRule.setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }

        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Grand Canal in Venice")
            .assertExists("Something is wrong with the next button")
    }
}