package com.example.redsetorbicksapp

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.redsetorbicksapp.ui.theme.RedSetorBicksAppTheme
import com.example.redsetorbicksapp.ui.components.BottomNav
import com.example.redsetorbicksapp.ui.screens.*
import com.example.redsetorbicksapp.viewmodel.OrderViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedSetorBicksAppTheme {
               SetorBicksApp()
            }
        }
    }
}

@Composable
fun SetorBicksApp() {
    val navController = rememberNavController()
    val orderViewModel: OrderViewModel = viewModel()
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(orderViewModel) }
            composable("reward") { RewardScreen(orderViewModel) }
            composable("order") { OrderScreen(orderViewModel) }
            composable("profile") { ProfileScreen() }
        }
    }
}