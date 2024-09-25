package com.example.ui.screens.enterPin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.AddUserUseCase
import com.example.ui.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class EnterPinScreenViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val addUserUseCase: AddUserUseCase
) : ViewModel() {
    private val enterPinStateMutable =
        MutableStateFlow<EnterPinState>(EnterPinState.Loading)
    private val enterPinState: StateFlow<EnterPinState> = enterPinStateMutable

    init {
        getMailId()
    }

    fun getEnterPinState(): StateFlow<EnterPinState> = enterPinState

    fun updatePin(pin: String) {
        enterPinStateMutable.update { state ->
            when (state) {
                is EnterPinState.EnterPin -> {
                    state.copy(pin = pin)
                }

                EnterPinState.Loading -> state
            }
        }
    }

    fun addUser(mail: String) {
        viewModelScope.launch {
            addUserUseCase.invoke(mail)
        }
    }

    private fun getMailId() {
        val mail = savedStateHandle.get<String>(Screen.KEY_MAIL)
            ?: throw NoSuchElementException("Mail not found")
        enterPinStateMutable.update { EnterPinState.EnterPin(mail = mail, pin = "") }
    }
}