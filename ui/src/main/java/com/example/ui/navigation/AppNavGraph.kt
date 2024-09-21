package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    mainScreenContent: @Composable () -> Unit,
    vacanciesByMatchScreenContent: @Composable () -> Unit,
    favoritesScreenContent: @Composable () -> Unit,
    responsesScreenContent: @Composable () -> Unit,
    messagesScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Search.route
    ) {
        searchNavGraph(
            mainScreenContent = mainScreenContent,
            vacanciesByMatchScreenContent = vacanciesByMatchScreenContent
        )
        composable(Screen.Favorites.route) {
            favoritesScreenContent()
        }
        composable(Screen.Responses.route) {
            responsesScreenContent()
        }
        composable(Screen.Messages.route) {
            messagesScreenContent()
        }
        composable(Screen.Profile.route) {
            profileScreenContent()
        }
    }
}