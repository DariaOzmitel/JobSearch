package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

object JobSearchTheme {
    val colors: JobSearchColors
        @Composable get() = LocalColors.current
    val typography: JobSearchTypography
        @Composable get() = LocalTypography.current
}

@Composable
fun JobSearchTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides AppColors,
        LocalTypography provides JobSearchTypographyValue,
    ) {
        MaterialTheme(
            content = content
        )
    }
}