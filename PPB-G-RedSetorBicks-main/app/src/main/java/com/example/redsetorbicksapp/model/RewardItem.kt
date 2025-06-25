package com.example.redsetorbicksapp.model

import androidx.annotation.DrawableRes

data class RewardItem(
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int,
    val requiredPoints: Int
)