package com.example.ui.screens.vacanciesByMatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.ChangeFavoriteStatusUseCase
import com.example.domain.usecases.GetVacancyListUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VacanciesByMatchScreenViewModel(
    private val getVacancyListUseCase: GetVacancyListUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
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
            getVacancyList()
        }
    }

    fun getVacancyList() {
        viewModelScope.launch {
            vacanciesByMatchStateMutable.update {
                VacanciesByMatchState.VacancyList(
                    mapper.vacancyToVacancyCardUiList(
                        getVacancyListUseCase.invoke()
                    )
                )
            }
        }
    }
}