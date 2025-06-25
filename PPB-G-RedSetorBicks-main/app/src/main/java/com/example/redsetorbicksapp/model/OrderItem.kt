package com.example.redsetorbicksapp.model

data class OrderItem(
    val menu: MenuItem,
    var quantity: Int = 1
)