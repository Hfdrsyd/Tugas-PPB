package com.example.redsetorbicksapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.font.FontWeight

import com.example.redsetorbicksapp.ui.components.OrderCard
import com.example.redsetorbicksapp.viewmodel.OrderViewModel

@Composable
fun OrderScreen(orderViewModel: OrderViewModel) {
    val orders = orderViewModel.orders

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Pesanan Anda",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (orders.isEmpty()) {
            Text("Belum ada pesanan.")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(orders) { orderItem ->
                    OrderCard(orderItem = orderItem)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Total: Rp${orderViewModel.getTotalPrice()}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
