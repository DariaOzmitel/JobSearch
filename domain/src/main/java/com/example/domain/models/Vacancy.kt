package com.example.domain.models

data class Vacancy(
    val id: String,
    val lookingNumber: Int? = null,
    val title: String,
    val address: Address,
    val company: String,
    val experienceText: String,
    val publishedDate: String,
)
