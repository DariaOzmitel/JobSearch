package com.example.ui.screens.vacanciesByMatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetVacancyListUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VacancyByMatchScreenViewModel(
    private val getVacancyListUseCase: GetVacancyListUseCase,
    private val mapper: DomainToUiMapper
) : ViewModel() {
    private val vacancyByMatchStateMutable =
        MutableStateFlow<VacancyByMatchState>(VacancyByMatchState.Loading)
    private val vacancyByMatchState: StateFlow<VacancyByMatchState> = vacancyByMatchStateMutable

    init {
        viewModelScope.launch {
            getVacancyList()
        }
    }

    fun getVacancyByMatchState(): StateFlow<VacancyByMatchState> = vacancyByMatchState

    private fun getVacancyList() {
        viewModelScope.launch {
            vacancyByMatchStateMutable.update {
                VacancyByMatchState.VacancyList(
                    mapper.vacancyToVacancyCardUiList(
                        getVacancyListUseCase.invoke()
                    )
                )
            }
        }
    }
}