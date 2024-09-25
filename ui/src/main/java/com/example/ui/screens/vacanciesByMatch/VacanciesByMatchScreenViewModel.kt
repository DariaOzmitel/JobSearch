package com.example.ui.screens.vacanciesByMatch

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

class VacanciesByMatchScreenViewModel(
    private val getVacancyListUseCase: GetVacancyListUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
    private val getFavoriteVacanciesListUseCase: GetFavoriteVacanciesListUseCase,
    private val mapper: DomainToUiMapper
) : ViewModel() {
    private val vacanciesByMatchStateMutable =
        MutableStateFlow<VacanciesByMatchState>(VacanciesByMatchState.Loading)
    private val vacanciesByMatchState: StateFlow<VacanciesByMatchState> =
        vacanciesByMatchStateMutable

    init {
        viewModelScope.launch {
            getVacancyList()
        }
    }

    fun getVacancyByMatchState(): StateFlow<VacanciesByMatchState> = vacanciesByMatchState

    fun changeFavoriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(vacancyId)

            vacanciesByMatchStateMutable.update { state ->

                when (state) {
                    is VacanciesByMatchState.VacancyList -> {
                        val updatedList = state.vacancyList.map { vacancy ->
                            when {
                                vacancy.id == vacancyId -> vacancy.copy(isFavorite = !vacancy.isFavorite)
                                else -> vacancy
                            }
                        }
                        state.copy(vacancyList = updatedList)
                    }

                    VacanciesByMatchState.Loading -> state
                }
            }
        }
    }

    private suspend fun getFavoriteVacanciesList(): List<String>? {
        return getFavoriteVacanciesListUseCase.invoke()
    }

    private fun getVacancyList() {
        viewModelScope.launch {
            vacanciesByMatchStateMutable.update {
                VacanciesByMatchState.VacancyList(
                    mapper.vacancyToVacancyCardUiList(
                        getVacancyListUseCase.invoke(),
                        getFavoriteVacanciesList()
                    )
                )
            }
        }
    }
}