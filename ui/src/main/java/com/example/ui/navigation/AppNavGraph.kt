package com.example.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ui.screens.root.RootScreen

@Composable
internal fun AppNavGraph(
    navHostController: NavHostController,
    navigationState: NavigationState,
    mainScreenContent: @Composable (PaddingValues) -> Unit,
    vacanciesByMatchScreenContent: @Composable (PaddingValues) -> Unit,
    vacancyScreenContent: @Composable (PaddingValues) -> Unit,
    favoritesScreenContent: @Composable (PaddingValues) -> Unit,
    responsesScreenContent: @Composable (PaddingValues) -> Unit,
    messagesScreenContent: @Composable (PaddingValues) -> Unit,
    profileScreenContent: @Composable (PaddingValues) -> Unit,
    logInScreenContent: @Composable (PaddingValues) -> Unit,
    enterPinScreenContent: @Composable (PaddingValues) -> Unit,
    splashScreenContent: @Composable () -> Unit,
) {
    RootScreen(navigationState = navigationState) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Splash.route
        ) {
            composable(Screen.Splash.route) {
                splashScreenContent()
            }
            composable(Screen.LogIn.route) {
                logInScreenContent(innerPadding)
            }
            composable(route = Screen.EnterPin.route,
                arguments = listOf(
                    navArgument(name = Screen.KEY_MAIL) {
                        type = NavType.StringType
                    }
                )
            ) {
                enterPinScreenContent(innerPadding)
            }
            searchNavGraph(
                mainScreenContent = { mainScreenContent(innerPadding) },
                vacanciesByMatchScreenContent = { vacanciesByMatchScreenContent(innerPadding) },
                vacancyScreenContent = { vacancyScreenContent(innerPadding) }
            )
            composable(Screen.Favorites.route) {
                favoritesScreenContent(innerPadding)
            }
            composable(Screen.Responses.route) {
                responsesScreenContent(innerPadding)
            }
            composable(Screen.Messages.route) {
                messagesScreenContent(innerPadding)
            }
            composable(Screen.Profile.route) {
                profileScreenContent(innerPadding)
            }
        }
    }
}