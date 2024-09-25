package com.example.domain.models

data class Vacancy(
    val id: String,
    val lookingNumber: Int? = null,
    val title: String,
    val address: Address,
    val company: String,
    val experiencePreviewText: String,
    val experienceText: String,
    val publishedDate: String,
    val salary: String,
    val schedules: String,
    val appliedNumber: Int?,
    val description: String?,
    val responsibilities: String,
    val isFavorite: Boolean = false,
    val questions: List<String>
)
