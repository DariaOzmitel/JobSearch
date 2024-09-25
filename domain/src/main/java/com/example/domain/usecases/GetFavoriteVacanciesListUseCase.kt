package com.example.domain.usecases

import com.example.domain.models.Vacancy
import com.example.domain.repository.JobSearchRepository

class GetFavoriteVacanciesListUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(): List<Vacancy> {
        return repository.getFavoriteVacanciesList()
    }
}