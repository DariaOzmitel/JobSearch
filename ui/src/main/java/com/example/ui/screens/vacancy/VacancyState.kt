package com.example.ui.screens.vacancy

import com.example.ui.models.VacancyForScreenUi

sealed class VacancyState {
    data class Vacancy(
        val vacancy: VacancyForScreenUi,
    ) : VacancyState()

    object Loading : VacancyState()
}