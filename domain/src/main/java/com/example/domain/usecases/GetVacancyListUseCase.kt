package com.example.domain.usecases

import com.example.domain.models.Vacancy
import com.example.domain.repository.JobSearchRepository

class GetVacancyListUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(): List<Vacancy> {
        return repository.getVacancyList()
    }
}