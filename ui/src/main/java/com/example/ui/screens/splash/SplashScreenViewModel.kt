package com.example.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.CheckAuthorizationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SplashScreenViewModel(private val checkAuthorizationUseCase: CheckAuthorizationUseCase) :
    ViewModel() {
    private val isUserAuthorizedMutable = MutableStateFlow(false)
    private val isUserAuthorized: StateFlow<Boolean> = isUserAuthorizedMutable


    init {
        checkAuthorization()
    }

    fun getStatusFlow(): StateFlow<Boolean> = isUserAuthorized

    private fun checkAuthorization() {
        viewModelScope.launch {
            checkAuthorizationUseCase.invoke().collect { authorizationStatus ->
                isUserAuthorizedMutable.update {
                    authorizationStatus
                }
            }
        }
    }
}