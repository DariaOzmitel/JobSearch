package com.example.data.network.models

internal data class AddressDto(
    val town: String,
    val street: String,
    val house: String
)

internal data class ExperienceDto(
    val previewText: String,
    val text: String
)

internal data class SalaryDto(
    val short: String? = null,
    val full: String
)

internal data class VacancyDto(
    val id: String,
    val lookingNumber: Int?,
    val title: String,
    val address: AddressDto,
    val company: String,
    val experience: ExperienceDto,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryDto,
    val schedules: List<String>,
    val appliedNumber: Int?,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)

internal data class VacanciesDto(
    val vacancies: List<VacancyDto>
)
