package com.example.navigationdrawerapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.navigationdrawerapplication.pages.*

@Composable
fun NavigationFlowGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomePage(navController) }
        composable("gridView") { GalleryGrid(navController) }
        composable("staggered") { StaggeredGridPage(navController) }
    }
}