package com.example.ui.screens.vacanciesByMatch

import com.example.ui.models.VacancyCardUI

sealed class VacancyByMatchState {
    data class VacancyList(
        val vacancyList: List<VacancyCardUI>,
    ) : VacancyByMatchState()

    object Loading : VacancyByMatchState()
}