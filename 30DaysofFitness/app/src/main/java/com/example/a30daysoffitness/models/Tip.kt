package com.example.a30daysoffitness.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val day : Int,
    @StringRes val workoutRes: Int,
    @StringRes val workoutDescriptionRes : Int,
    @DrawableRes val imageRes : Int
)
