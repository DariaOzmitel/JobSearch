package com.example.ui.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.ChangeFavoriteStatusUseCase
import com.example.domain.usecases.GetFavoriteVacanciesListUseCase
import com.example.domain.usecases.GetVacancyListUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteScreenViewModel(
    private val getVacancyListUseCase: GetVacancyListUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
    private val getFavoriteVacanciesListUseCase: GetFavoriteVacanciesListUseCase,
    private val mapper: DomainToUiMapper
) : ViewModel() {
    private val favoriteStateMutable =
        MutableStateFlow<FavoriteState>(FavoriteState.Loading)
    private val favoriteState: StateFlow<FavoriteState> =
        favoriteStateMutable

    init {
        viewModelScope.launch {
            getFavoriteVacanciesList()
        }
    }

    fun getFavoriteState(): StateFlow<FavoriteState> = favoriteState

    fun changeFavoriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(vacancyId)
            getFavoriteVacanciesList()
        }
    }

    private fun getFavoriteVacanciesList() {
        viewModelScope.launch {
            favoriteStateMutable.update {
                FavoriteState.VacancyList(
                    mapper.vacancyToVacancyCardUiList(
                        getFavoriteVacanciesListUseCase.invoke()
                    )
                )
            }
        }
    }
}