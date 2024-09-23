package com.example.domain.usecases

import com.example.domain.models.Vacancy
import com.example.domain.repository.JobSearchRepository

class GetVacancyUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(id: String): Vacancy {
        return repository.getVacancy(id)
    }
}