package com.example.lemonadeapp.ui

import android.media.Image
import android.media.MediaDescription
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.lemonadeapp.R

data class LemonadeAppUiState(
    @DrawableRes val image: Int = 0,
    @StringRes val description: Int = 0
)
