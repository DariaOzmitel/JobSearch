package com.example.ui.items

import androidx.annotation.DrawableRes

data class RecommendationUI(
    @DrawableRes val iconResId: Int? = null,
    val title: String,
    val buttonText: String? = null
)
