package com.example.redsetorbicksapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.redsetorbicksapp.model.MenuItem
import com.example.redsetorbicksapp.R
import com.example.redsetorbicksapp.ui.components.MenuCard
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource

import com.example.redsetorbicksapp.viewmodel.OrderViewModel

@Composable
fun HomeScreen(orderViewModel: OrderViewModel) {
    val menuList = remember {
        listOf(
            MenuItem(5, "Vanilla Latte", R.drawable.vanillalatte, 21000),
            MenuItem(6, "Espresso", R.drawable.espresso, 20000),
            MenuItem(7, "Oat Latte", R.drawable.oatlatte, 18000),
            MenuItem(8, "Iced Lemonade Tea", R.drawable.iceshakenlemontea, 19000),
            MenuItem(9, "Cold Foam", R.drawable.coldfoam, 25000),
            MenuItem(10, "Java Chip Frappucino", R.drawable.javachipfrappuchino, 35000),
            MenuItem(1, "Caramel Macchiato", R.drawable.caramelmacchiato, 23000),
            MenuItem(2, "Caffe Latte", R.drawable.caffelatte, 30000),
            MenuItem(3, "Cold Brew", R.drawable.coldbrew, 24000),
            MenuItem(4, "Mocha Frappuccino", R.drawable.mochafrappuccino, 32000)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.setubrukaffe),
                contentDescription = "Logo Setubruk",
                modifier = Modifier
                    .size(60.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Setubruk",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Grid menu
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(menuList) { menu ->
                MenuCard(
                    menu = menu,
                    onAddClick = {
                        orderViewModel.addToOrder(menu)
                    }
                )
            }
        }
    }
}