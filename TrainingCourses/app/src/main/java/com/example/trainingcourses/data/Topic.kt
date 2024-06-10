package com.example.trainingcourses.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val StringResourceId : Int,
    val number : Int,
    @DrawableRes val ImageResourceId : Int
)
