package com.example.ui.screens.vacancy

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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