package com.example.ui.models

import androidx.annotation.DrawableRes

internal data class OfferUI(
    @DrawableRes val iconResId: Int? = null,
    val title: String,
    val buttonText: String? = null
)
