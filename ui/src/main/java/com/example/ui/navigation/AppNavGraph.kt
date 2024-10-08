package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
internal fun AppNavGraph(
    navHostController: NavHostController,
    mainScreenContent: @Composable () -> Unit,
    vacanciesByMatchScreenContent: @Composable () -> Unit,
    vacancyScreenContent: @Composable () -> Unit,
    favoritesScreenContent: @Composable () -> Unit,
    responsesScreenContent: @Composable () -> Unit,
    messagesScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    logInScreenContent: @Composable () -> Unit,
    enterPinScreenContent: @Composable () -> Unit,
    splashScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            splashScreenContent()
        }
        composable(Screen.LogIn.route) {
            logInScreenContent()
        }
        composable(route = Screen.EnterPin.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_MAIL) {
                    type = NavType.StringType
                }
            )
        ) {
            enterPinScreenContent()
        }
        searchNavGraph(
            mainScreenContent = mainScreenContent,
            vacanciesByMatchScreenContent = vacanciesByMatchScreenContent,
            vacancyScreenContent = vacancyScreenContent
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