package com.example.navigationdrawerapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawerapplication.pages.GalleryGrid
import com.example.navigationdrawerapplication.pages.HomePage
import com.example.navigationdrawerapplication.pages.StaggeredGridPage

@Composable
fun NavigationFlowGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomePage(navController) }
        composable("settings") { GalleryGrid(navController) }
        composable("staggered") { StaggeredGridPage() }
    }
}