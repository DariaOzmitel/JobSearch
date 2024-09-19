package com.example.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui.R

private val sfProDisplayFamily = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
)

@Immutable
data class JobSearchTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val text1: TextStyle,
    val buttonText1: TextStyle,
    val buttonText2: TextStyle,
    val tabText: TextStyle,
    val number: TextStyle,
)

val JobSearchTypographyValue = JobSearchTypography(
    title1 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),
    title2 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    title3 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    title4 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    text1 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    buttonText1 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    buttonText2 = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    tabText = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    number = TextStyle(
        fontFamily = sfProDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 7.sp
    ),
)

internal val LocalTypography = staticCompositionLocalOf { JobSearchTypographyValue }