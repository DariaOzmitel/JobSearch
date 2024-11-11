package com.example.ui.screens.vacancy

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.ChangeFavoriteStatusUseCase
import com.example.domain.usecases.GetVacancyUseCase
import com.example.ui.mapper.DomainToUiMapper
import com.example.ui.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class VacancyScreenViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getVacancyUseCase: GetVacancyUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
    private val mapper: DomainToUiMapper
) : ViewModel() {
    private val vacancyStateMutable =
        MutableStateFlow<VacancyState>(VacancyState.Loading)
    private val vacancyState: StateFlow<VacancyState> = vacancyStateMutable

    init {
        viewModelScope.launch {
            getVacancy()
        }
    }

    fun getVacancyState(): StateFlow<VacancyState> = vacancyState

    fun changeFavoriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(vacancyId)
//            vacancyStateMutable.update { state ->
//                when (state) {
//                    is VacancyState.Vacancy -> {
//                        val updatedVacancy =
//                            state.vacancy.copy(isFavorite = !state.vacancy.isFavorite)
//                        state.copy(vacancy = updatedVacancy)
//                    }
//
//                    VacancyState.Loading -> state
//                }
//            }
        }
    }

    private fun getVacancyId(): String {
        return savedStateHandle.get<String>(Screen.KEY_VACANCY_ID)
            ?: throw NoSuchElementException("Vacancy not found")
    }

    private fun getVacancy() {
        viewModelScope.launch {
            getVacancyUseCase.invoke(getVacancyId()).collect { vacancy ->
                vacancyStateMutable.update {
                    VacancyState.Vacancy(
                        mapper.vacancyToVacancyScreenUi(
                            vacancy
                        )
                    )
                }
            }
        }
    }
}