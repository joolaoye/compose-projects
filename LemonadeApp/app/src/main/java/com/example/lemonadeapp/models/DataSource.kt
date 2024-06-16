package com.example.lemonadeapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.lemonadeapp.R

const val NUMBER_ITEMS = 4

object DataSource {
    val items = mutableListOf(
        Item(
            image = R.drawable.lemon_tree,
            description = R.string.tap_lemon_tree),
        Item(
            image = R.drawable.lemon_squeeze,
            description = R.string.keep_tapping),
        Item(
            image = R.drawable.lemon_drink,
            description = R.string.tap_lemonade),
        Item(
            image = R.drawable.lemon_restart,
            description = R.string.tap_empty_glass)
    )

    fun loadItems() : MutableList<Item> {
        return items
    }
}

data class Item (
    @DrawableRes val image: Int,
    @StringRes val description: Int
)