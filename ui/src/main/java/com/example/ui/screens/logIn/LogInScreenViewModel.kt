package com.example.ui.screens.logIn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class LogInScreenViewModel : ViewModel() {
    private val logInMailMutable =
        MutableStateFlow("")
    private val logInMail: StateFlow<String> = logInMailMutable

    fun getLogInMail(): StateFlow<String> = logInMail

    fun updateMail(mail: String) {
        logInMailMutable.update { mail }
    }
}