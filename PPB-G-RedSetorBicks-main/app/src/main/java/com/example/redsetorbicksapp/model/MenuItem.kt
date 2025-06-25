package com.example.redsetorbicksapp.model

import androidx.annotation.DrawableRes

data class MenuItem(
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int,
    val price: Int
)