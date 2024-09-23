package com.example.ui

import com.example.ui.models.OfferUI
import com.example.ui.models.VacancyCardUI
import com.example.ui.models.VacancyForScreenUi

val mockRecommendation = OfferUI(
    iconResId = R.drawable.favorites,
    title = "Временная работа или подработка",
    buttonText = "Полезные статьи и советы"
)
val mockRecommendationList = listOf(
    OfferUI(
        iconResId = R.drawable.favorites,
        title = "Временная работа или подработка",
        buttonText = "Полезные статьи и советы"
    ),
    OfferUI(
        iconResId = R.drawable.favorites,
        title = "Временная работа или подработка",
        buttonText = "Полезные статьи и советы"
    ),
    OfferUI(
        iconResId = R.drawable.favorites,
        title = "Временная работа или подработка",
    ),
    OfferUI(
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
    mockVacancy,
    mockVacancy,
    mockVacancy,
    mockVacancy,
    mockVacancy,
)

val mockVacancyForScreen = VacancyForScreenUi(
    lookingNumber = 5,
    title = "Старший Android разработчик",
    address = "Москва, ул. Примерная, д. 123",
    company = "ТехКорп",
    experience = "3-5 лет",
    salary = "100,000 руб.",
    schedules = "Полная занятость",
    appliedNumber = 20,
    description = "Увлекательная возможность работать над современными мобильными технологиями.",
    responsibilities = "Разработка и поддержка Android приложений.",
    questions = listOf(
        "Какой график работы?",
        "Можно ли работать удаленно?",
        "Какие предоставляются льготы?"
    )
)

