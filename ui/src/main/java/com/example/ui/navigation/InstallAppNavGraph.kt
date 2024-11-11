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
import com.example.ui.screens.favorites.FavoriteScreen
import com.example.ui.screens.logIn.LogInScreen
import com.example.ui.screens.main.MainScreen
import com.example.ui.screens.splash.SplashScreen
import com.example.ui.screens.vacanciesByMatch.VacanciesByMatchScreen
import com.example.ui.screens.vacancy.VacancyScreen

@Composable
fun InstallAppNavGraph() {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        navigationState = navigationState,
        splashScreenContent = {
            SplashScreen { authorizationStatus ->
                when (authorizationStatus) {
                    true -> navigationState.navigateTo(
                        route = Screen.Main.route,
                        inclusive = true,
                        popUpToScreen = Screen.Splash.route
                    )

                    false -> navigationState.navigateTo(
                        route = Screen.LogIn.route, inclusive = true,
                        popUpToScreen = Screen.Splash.route
                    )
                }
            }
        },
        mainScreenContent = { innerPadding ->
            MainScreen(innerPadding = innerPadding, onCardClickListener = { vacancyId ->
                navigationState.navigateToVacancy(vacancyId)
            }) {
                navigationState.navigateTo(Screen.VacanciesByMatch.route)
            }
        },
        logInScreenContent = { innerPadding ->
            LogInScreen(innerPadding = innerPadding, onButtonClickListener = { mail ->
                navigationState.navigateToEnterPin(mail)
            })
        },
        enterPinScreenContent = { innerPadding ->
            EnterPinScreen(innerPadding = innerPadding) {
                navigationState.navigateTo(
                    route = Screen.Main.route,
                    inclusive = true,
                    popUpToScreen = Screen.EnterPin.route
                )
            }
        },
        favoritesScreenContent = { innerPadding ->
            FavoriteScreen(
                innerPadding = innerPadding,
                onButtonClickListener = {}) { vacancyId ->
                navigationState.navigateToVacancy(
                    vacancyId = vacancyId,
                    popUpToScreen = Screen.Favorites.route
                )
            }
        },
        responsesScreenContent = { innerPadding ->
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                painter = painterResource(id = R.drawable.responses_example),
                contentDescription = stringResource(
                    id = R.string.responses
                )
            )
        },
        messagesScreenContent = { innerPadding ->
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                painter = painterResource(id = R.drawable.messages_example),
                contentDescription = stringResource(
                    id = R.string.messages
                )
            )
        },
        profileScreenContent = { innerPadding ->
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                painter = painterResource(id = R.drawable.profile_examples),
                contentDescription = stringResource(
                    id = R.string.profile
                )
            )
        },
        vacanciesByMatchScreenContent = { innerPadding ->
            VacanciesByMatchScreen(innerPadding = innerPadding) { vacancyId ->
                navigationState.navigateToVacancy(
                    vacancyId = vacancyId,
                    popUpToScreen = Screen.VacanciesByMatch.route
                )
            }
        },
        vacancyScreenContent = { innerPadding ->
            VacancyScreen(innerPadding = innerPadding) {
                navigationState.navHostController.navigateUp()
            }
        }
    )
}