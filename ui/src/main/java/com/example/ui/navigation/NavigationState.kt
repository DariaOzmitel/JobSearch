package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(val navHostController: NavHostController) {
    fun navigateTo(
        route: String,
        inclusive: Boolean = false,
        popUpToScreen: String = Screen.Main.route,
    ) {
        navHostController.navigate(route) {
            when (popUpToScreen) {
                Screen.EnterPin.route -> {
                    popUpTo(0) {
                        this.inclusive = inclusive
                    }
                    launchSingleTop = true
                }

                else -> {
                    popUpTo(popUpToScreen) {
                        this.inclusive = inclusive
                    }
                    launchSingleTop = true
                }
            }

        }
    }

    fun navigateToVacancy(
        vacancyId: String,
        popUpToScreen: String = Screen.Main.route,
    ) {
        navHostController.navigate(route = Screen.Vacancy.getRouteWithArgs(vacancyId)) {
            popUpTo(popUpToScreen) {
            }
            launchSingleTop = false
        }
    }

    fun navigateToEnterPin(mail: String) {
        navHostController.navigate(route = Screen.EnterPin.getRouteWithArgs(mail)) {
            popUpTo(Screen.LogIn.route) {
                inclusive = false
            }
            launchSingleTop = true
        }
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}