package com.example.ui.screens.enterPin

sealed class EnterPinState {
    data class EnterPin(
        val mail: String,
        val pin: String,
    ) : EnterPinState()

    object Loading : EnterPinState()
}