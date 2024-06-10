package com.example.artspaceapp

import androidx.annotation.DrawableRes

data class Art (
    @DrawableRes val Image : Int,
    val Name : String,
    val Creator : String,
    val YearTaken : String
)
