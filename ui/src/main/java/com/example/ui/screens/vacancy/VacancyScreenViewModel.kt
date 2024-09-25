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

class VacancyScreenViewModel(
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

    private fun getVacancyId(): String {
        return savedStateHandle.get<String>(Screen.KEY_VACANCY_ID)
            ?: throw NoSuchElementException("Vacancy not found")
    }

    fun changeFavoriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(vacancyId)
            vacancyStateMutable.update { state ->
                when (state) {
                    is VacancyState.Vacancy -> {
                        val updatedVacancy =
                            state.vacancy.copy(isFavorite = !state.vacancy.isFavorite)
                        state.copy(vacancy = updatedVacancy)
                    }

                    VacancyState.Loading -> state
                }
            }
        }
    }

    private fun getVacancy() {
        viewModelScope.launch {
            vacancyStateMutable.update {
                VacancyState.Vacancy(
                    mapper.vacancyToVacancyScreenUi(
                        getVacancyUseCase.invoke(getVacancyId())
                    )
                )
            }
        }
    }
}