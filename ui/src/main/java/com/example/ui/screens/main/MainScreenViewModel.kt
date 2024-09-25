package com.example.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.ChangeFavoriteStatusUseCase
import com.example.domain.usecases.GetFavoriteVacanciesListUseCase
import com.example.domain.usecases.GetOfferListUseCase
import com.example.domain.usecases.GetVacancyListUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getVacancyListUseCase: GetVacancyListUseCase,
    private val getOfferListUseCase: GetOfferListUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
    private val getFavoriteVacanciesListUseCase: GetFavoriteVacanciesListUseCase,
    private val mapper: DomainToUiMapper
) : ViewModel() {
    private val mainStateMutable =
        MutableStateFlow<MainState>(MainState.Loading)
    private val mainState: StateFlow<MainState> = mainStateMutable

    init {
        viewModelScope.launch {
            getVacancyList()
        }
    }

    fun getMainState(): StateFlow<MainState> = mainState

    fun changeFavoriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(vacancyId)

            mainStateMutable.update { state ->

                when (state) {
                    is MainState.VacancyList -> {
                        val updatedList = state.vacancyList.map { vacancy ->
                            when {
                                vacancy.id == vacancyId -> vacancy.copy(isFavorite = !vacancy.isFavorite)
                                else -> vacancy
                            }
                        }
                        state.copy(vacancyList = updatedList)
                    }

                    MainState.Loading -> state
                }
            }
        }
    }

    private suspend fun getFavoriteVacanciesList(): List<String>? {
        return getFavoriteVacanciesListUseCase.invoke()
    }

    private fun getVacancyList() {
        viewModelScope.launch {
            mainStateMutable.update {
                MainState.VacancyList(
                    mapper.vacancyToVacancyCardUiList(
                        getVacancyListUseCase.invoke(),
                        getFavoriteVacanciesList()
                    ),
                    offerList = mapper.offerToOfferCardUiList(getOfferListUseCase.invoke())
                )
            }
        }
    }
}