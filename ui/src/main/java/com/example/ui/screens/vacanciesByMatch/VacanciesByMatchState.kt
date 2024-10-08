package com.example.ui.screens.vacanciesByMatch

import com.example.ui.models.VacancyCardUI

internal sealed class VacanciesByMatchState {
    data class VacancyList(
        val vacancyList: List<VacancyCardUI>,
    ) : VacanciesByMatchState()

    object Loading : VacanciesByMatchState()
}