package com.example.redsetorbicksapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.redsetorbicksapp.ui.components.RewardCard
import com.example.redsetorbicksapp.viewmodel.OrderViewModel

@Composable
fun RewardScreen(orderViewModel: OrderViewModel) {
    val rewards = orderViewModel.rewards
    val starPoints = orderViewModel.starPoints

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "⭐ $starPoints Star Points",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        rewards.forEach { reward ->
            RewardCard(
                reward = reward,
                starPoints = starPoints,
                onRedeem = { orderViewModel.redeemReward(it) }
            )
        }
    }
}
