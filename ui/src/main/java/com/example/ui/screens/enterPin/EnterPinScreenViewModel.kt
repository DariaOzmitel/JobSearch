package com.example.ui.screens.enterPin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ui.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class EnterPinScreenViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val enterPinStateMutable =
        MutableStateFlow<EnterPinState>(EnterPinState.Loading)
    private val enterPinState: StateFlow<EnterPinState> = enterPinStateMutable

    init {
        getMailId()
    }

    fun getEnterPinState(): StateFlow<EnterPinState> = enterPinState

    private fun getMailId() {
        val mail = savedStateHandle.get<String>(Screen.KEY_MAIL)
            ?: throw NoSuchElementException("Mail not found")
        enterPinStateMutable.update { EnterPinState.EnterPin(mail = mail, pin = "") }
    }

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
}