package com.example.littlelemon

import android.content.Context
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.littlelemondl.Onboarding

@Composable
fun MyNavigation(context: Context, navController: NavHostController, items: List<MenuItemRoom>) {

    // startDestination
    val sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE)
    val userDataStored = sharedPreferences.getBoolean("user_data_stored", false)

    val startDestination = if (userDataStored) com.example.littlelemondl.Home.route else Onboarding.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(com.example.littlelemondl.Home.route) {
            Home(context, navController, items)
        }
        composable(Onboarding.route) {
            Onboarding(context, navController)
        }
        composable(com.example.littlelemondl.Profile.route) {
            Profile(context, navController)
        }


    }

}