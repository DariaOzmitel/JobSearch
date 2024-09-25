package com.example.ui.screens.favorites

import com.example.ui.models.VacancyCardUI

sealed class FavoriteState {
    data class VacancyList(
        val vacancyList: List<VacancyCardUI>,
    ) : FavoriteState()

    object Loading : FavoriteState()
}