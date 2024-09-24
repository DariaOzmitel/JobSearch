package com.example.ui.screens.logIn

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetVacancyUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LogInScreenViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getVacancyUseCase: GetVacancyUseCase,
    private val mapper: DomainToUiMapper
) : ViewModel() {
    private val logInMailMutable =
        MutableStateFlow("")
    private val logInMail: StateFlow<String> = logInMailMutable

    fun getLogInMail(): StateFlow<String> = logInMail

    fun updateMail(mail: String) {
        logInMailMutable.update { mail }
    }
}