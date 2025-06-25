package com.example.redsetorbicksapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class NavItem(val route: String, val label: String, val icon: ImageVector)

@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        NavItem("home", "Home", Icons.Default.Home),
        NavItem("reward", "Reward", Icons.Default.Star),
        NavItem("order", "Order", Icons.Default.ShoppingCart),
        NavItem("profile", "Profile", Icons.Default.Person)
    )
    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}