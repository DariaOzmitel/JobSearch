package com.example.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.ChangeFavoriteStatusUseCase
import com.example.domain.usecases.GetOfferListUseCase
import com.example.domain.usecases.GetVacancyListUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MainScreenViewModel(
    private val getVacancyListUseCase: GetVacancyListUseCase,
    private val getOfferListUseCase: GetOfferListUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
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
            getVacancyList()
        }
    }

    fun getVacancyList() {
        viewModelScope.launch {
            mainStateMutable.update {
                MainState.VacancyList(
                    mapper.vacancyToVacancyCardUiList(
                        getVacancyListUseCase.invoke()
                    ),
                    offerList = mapper.offerToOfferCardUiList(getOfferListUseCase.invoke())
                )
            }
        }
    }
}