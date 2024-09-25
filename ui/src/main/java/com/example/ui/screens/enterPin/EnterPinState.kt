package com.example.ui.screens.enterPin

internal sealed class EnterPinState {
    data class EnterPin(
        val mail: String,
        val pin: String,
    ) : EnterPinState()

    object Loading : EnterPinState()
}