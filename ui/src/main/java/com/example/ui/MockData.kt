package com.example.ui

import com.example.ui.items.RecommendationUI
import com.example.ui.items.VacancyCardUI

val mockRecommendation = RecommendationUI(
    iconResId = R.drawable.favorites,
    title = "Временная работа или подработка",
    buttonText = "Полезные статьи и советы"
)
val mockRecommendationList = listOf(
    RecommendationUI(
        iconResId = R.drawable.favorites,
        title = "Временная работа или подработка",
        buttonText = "Полезные статьи и советы"
    ),
    RecommendationUI(
        iconResId = R.drawable.favorites,
        title = "Временная работа или подработка",
        buttonText = "Полезные статьи и советы"
    ),
    RecommendationUI(
        iconResId = R.drawable.favorites,
        title = "Временная работа или подработка",
    ),
    RecommendationUI(
        iconResId = R.drawable.favorites,
        title = "Временная работа или подработка",
        buttonText = "Полезные статьи и советы"
    )
)

val mockVacancy = VacancyCardUI(
    lookingNumber = 2,
    title = "UI/UX дизайнер",
    town = "Минск",
    company = "Мобирикс",
    experienceText = "Опыт от 1 до 3 лет",
    publishedDate = "20 февраля"
)

val mockVacanciesList = listOf(
    mockVacancy,
    VacancyCardUI(
        title = "UI/UX дизайнер",
        company = "Мобирикс",
        publishedDate = "20 февраля"
    ),
    mockVacancy,
    mockVacancy,
    mockVacancy,
    mockVacancy,
    mockVacancy,
)