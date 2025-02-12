package com.example.todolistapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("screen1/{taskText}") { backStackEntry ->
            val taskText = backStackEntry.arguments?.getString("taskText") ?: ""
            ShowTasks(navController = navController, taskText = taskText)
        }
        composable("screen1/{task}") { // Destination for "screen1" without arguments
            ShowTasks( navController = navController,taskText = "")
        }
    }
}