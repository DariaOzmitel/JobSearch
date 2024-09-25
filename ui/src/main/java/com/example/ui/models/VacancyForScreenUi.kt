package com.example.ui.models

data class VacancyForScreenUi(
    val id: String,
    val isFavorite: Boolean = false,
    val lookingNumber: Int?,
    val title: String,
    val address: String,
    val company: String,
    val experience: String,
    val salary: String,
    val schedules: String,
    val appliedNumber: Int?,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
)