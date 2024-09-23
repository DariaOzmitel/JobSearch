package com.example.ui.navigation

sealed class Screen(val route: String) {
    object Search : Screen(ROUTE_SEARCH)
    object Main : Screen(ROUTE_MAIN)
    object VacanciesByMatch : Screen(ROUTE_VACANCIES_BY_MATCH)
    object Vacancy : Screen(ROUTE_VACANCY) {

        private const val ROUTE_FOR_ARGS = "vacancy"

        fun getRouteWithArgs(vacancyId: String): String {
            return "$ROUTE_FOR_ARGS/$vacancyId"
        }
    }

    object Favorites : Screen(ROUTE_FAVORITES)
    object Responses : Screen(ROUTE_RESPONSES)
    object Messages : Screen(ROUTE_MESSAGES)
    object Profile : Screen(ROUTE_PROFILE)

    companion object {
        const val KEY_VACANCY_ID = "community_id"

        private const val ROUTE_SEARCH = "search"
        private const val ROUTE_MAIN = "main"
        private const val ROUTE_VACANCIES_BY_MATCH = "vacancies by match"
        private const val ROUTE_VACANCY = "vacancy/{$KEY_VACANCY_ID}"
        private const val ROUTE_FAVORITES = "favorites"
        private const val ROUTE_RESPONSES = "responses"
        private const val ROUTE_MESSAGES = "messages"
        private const val ROUTE_PROFILE = "profile"
    }
}