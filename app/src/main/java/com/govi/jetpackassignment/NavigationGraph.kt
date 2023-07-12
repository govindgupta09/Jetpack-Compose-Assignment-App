package com.govi.jetpackassignment

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.FeedPage.route ){

        composable(route = Screen.FeedPage.route){
            FeedPagePreview(navController = navController)
        }
        composable(route = Screen.CommentPage.route){
            CommentPage(navController = navController)
        }
    }
}