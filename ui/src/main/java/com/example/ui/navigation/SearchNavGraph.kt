package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.searchNavGraph(
    mainScreenContent: @Composable () -> Unit,
    vacanciesByMatchScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.Main.route,
        route = Screen.Search.route
    ) {
        composable(Screen.Main.route) {
            mainScreenContent()
        }
        composable(Screen.VacanciesByMatch.route) {
            vacanciesByMatchScreenContent()
        }
    }
}