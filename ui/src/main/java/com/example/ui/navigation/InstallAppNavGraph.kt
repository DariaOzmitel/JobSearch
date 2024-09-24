package com.example.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.screens.enterPin.EnterPinScreen
import com.example.ui.screens.logIn.LogInScreen
import com.example.ui.screens.main.MainScreen
import com.example.ui.screens.root.RootScreen
import com.example.ui.screens.splash.SplashScreen
import com.example.ui.screens.vacanciesByMatch.VacanciesByMatchScreen
import com.example.ui.screens.vacancy.VacancyScreen

@Composable
fun InstallAppNavGraph() {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        splashScreenContent = {
            SplashScreen { authorizationStatus ->
                when (authorizationStatus) {
                    true -> navigationState.navigateTo(Screen.Main.route)
                    false -> navigationState.navigateTo(Screen.LogIn.route)
                }
            }
        },
        mainScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                MainScreen(innerPadding = innerPadding, onCardClickListener = { vacancyId ->
                    navigationState.navigateToVacancy(vacancyId)
                }) {
                    navigationState.navigateTo(Screen.VacanciesByMatch.route)
                }

            }
        },
        logInScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                LogInScreen(innerPadding = innerPadding, onButtonClickListener = { mail ->
                    navigationState.navigateToEnterPin(mail)
                })
            }
        },
        enterPinScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                EnterPinScreen(innerPadding = innerPadding) {
                    navigationState.navigateTo(Screen.Main.route)
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
                VacanciesByMatchScreen(innerPadding = innerPadding) { vacancyId ->
                    navigationState.navigateToVacancy(vacancyId)
                }
            }
        },
        vacancyScreenContent = {
            RootScreen(navigationState = navigationState) { innerPadding ->
                VacancyScreen(innerPadding = innerPadding)
            }
        }
    )
}