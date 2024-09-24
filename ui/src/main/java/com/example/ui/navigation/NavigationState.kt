package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(val navHostController: NavHostController) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(Screen.Main.route) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToVacancy(vacancyId: String) {
        navHostController.navigate(route = Screen.Vacancy.getRouteWithArgs(vacancyId))
    }
    fun navigateToEnterPin(mail: String) {
        navHostController.navigate(route = Screen.EnterPin.getRouteWithArgs(mail))
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