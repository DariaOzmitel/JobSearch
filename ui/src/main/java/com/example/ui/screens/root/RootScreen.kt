package com.example.ui.screens.root

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ui.molecules.bottomBar.JobSearchBottomBar
import com.example.ui.navigation.NavigationState
import com.example.ui.navigation.Screen
import com.example.ui.theme.JobSearchTheme

@Composable
internal fun RootScreen(
    modifier: Modifier = Modifier,
    navigationState: NavigationState,
    content: @Composable (PaddingValues) -> Unit
) {
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = currentRoute != Screen.Splash.route
    Scaffold(modifier = modifier, containerColor = JobSearchTheme.colors.basicBlack,
        bottomBar = {
            if (showBottomBar) {
            JobSearchBottomBar(
                navBackStackEntry = navBackStackEntry,
                navigationState = navigationState
            )
            }
        }) { innerPadding ->
        content(innerPadding)
    }
}