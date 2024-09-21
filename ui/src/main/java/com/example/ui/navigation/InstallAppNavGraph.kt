package com.example.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.screens.main.MainScreen
import com.example.ui.screens.root.RootScreen
import com.example.ui.screens.vacanciesByMatch.VacanciesByMatchScreen

@Composable
fun InstallAppNavGraph() {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        mainScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                MainScreen(innerPadding = innerPadding) {
                    navigationState.navigateTo(Screen.VacanciesByMatch.route)
                }
            }
        },
        favoritesScreenContent = {},
        responsesScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    painter = painterResource(id = R.drawable.responses_example),
                    contentDescription = stringResource(
                        id = R.string.responses
                    )
                )
            }
        },
        messagesScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    painter = painterResource(id = R.drawable.messages_example),
                    contentDescription = stringResource(
                        id = R.string.messages
                    )
                )
            }
        },
        profileScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    painter = painterResource(id = R.drawable.profile_examples),
                    contentDescription = stringResource(
                        id = R.string.profile
                    )
                )
            }
        },
        vacanciesByMatchScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                VacanciesByMatchScreen(innerPadding = innerPadding)
            }
        }
    )
}