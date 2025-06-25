package com.example.redsetorbicksapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.redsetorbicksapp.R

import com.example.redsetorbicksapp.model.MenuItem
import com.example.redsetorbicksapp.model.OrderItem
import com.example.redsetorbicksapp.model.RewardItem

class OrderViewModel : ViewModel() {
    private val _orders = mutableStateListOf<OrderItem>()
    val orders: List<OrderItem> get() = _orders

    var starPoints by mutableStateOf(120) // Misal awalnya 120 poin
        private set

    val rewards = listOf(
        RewardItem(1, "Free Tall Latte", R.drawable.reward_latte, 50),
        RewardItem(2, "Free Muffin", R.drawable.reward_muffin, 70),
        RewardItem(3, "Exclusive Tumbler", R.drawable.reward_tumbler, 150)
    )

    fun addToOrder(menu: MenuItem) {
        val existingItem = _orders.find { it.menu.id == menu.id }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            _orders.add(OrderItem(menu = menu))
        }
    }

    fun getTotalPrice(): Int {
        return _orders.sumOf { it.menu.price * it.quantity }
    }

    fun redeemReward(reward: RewardItem) {
        if (starPoints >= reward.requiredPoints) {
            starPoints -= reward.requiredPoints
        }
    }

    fun clearOrder() {
        _orders.clear()
    }
}
