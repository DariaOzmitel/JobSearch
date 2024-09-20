package com.example.ui.navigation

sealed class Screen(val route: String) {
    object Search : Screen(ROUTE_SEARCH)
    object Favorites : Screen(ROUTE_FAVORITES)
    object Responses : Screen(ROUTE_RESPONSES)
    object Messages : Screen(ROUTE_MESSAGES)
    object Profile : Screen(ROUTE_PROFILE)

    companion object {
        private const val ROUTE_SEARCH = "search"
        private const val ROUTE_FAVORITES = "favorites"
        private const val ROUTE_RESPONSES = "responses"
        private const val ROUTE_MESSAGES = "messages"
        private const val ROUTE_PROFILE = "profile"
    }
}