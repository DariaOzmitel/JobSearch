package com.example.ui.screens.main

import com.example.ui.models.VacancyCardUI

sealed class MainState {
    data class VacancyList(
        val vacancyList: List<VacancyCardUI>,
    ) : MainState()

    object Loading : MainState()
}