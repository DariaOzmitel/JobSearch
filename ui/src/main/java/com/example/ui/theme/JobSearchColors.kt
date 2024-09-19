package com.example.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class JobSearchColors(
    val basicBlack: Color,
    val basicGrey1: Color,
    val basicGrey2: Color,
    val basicGrey3: Color,
    val basicGrey4: Color,
    val basicGrey5: Color,
    val basicWhite: Color,
    val specialBlue: Color,
    val specialDarkBlue: Color,
    val specialGreen: Color,
    val specialDarkGreen: Color,
    val specialRed: Color,
)

val AppColors = JobSearchColors(
    basicBlack = Color(0xFF0C0C0C),
    basicGrey1 = Color(0xFF222325),
    basicGrey2 = Color(0xFF313234),
    basicGrey3 = Color(0xFF858688),
    basicGrey4 = Color(0xFF9F9F9F),
    basicGrey5 = Color(0xFFDBDBDB),
    basicWhite = Color(0xFFFFFFFF),
    specialBlue = Color(0xFF2B7EFE),
    specialDarkBlue = Color(0xFF00427D),
    specialGreen = Color(0xFF4CB24E),
    specialDarkGreen = Color(0xFF015905),
    specialRed = Color(0xFFFF0000),
)

internal val LocalColors = staticCompositionLocalOf { AppColors }