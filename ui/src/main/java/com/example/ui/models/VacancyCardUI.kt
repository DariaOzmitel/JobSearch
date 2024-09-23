package com.example.ui.models

data class VacancyCardUI(
    val id: String,
    val lookingNumber: Int? = null,
    val title: String,
    val town: String,
    val company: String,
    val experienceText: String,
    val publishedDate: String,
)


