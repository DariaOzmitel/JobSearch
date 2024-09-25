package com.example.domain.usecases

import com.example.domain.repository.JobSearchRepository

class GetFavoriteVacanciesListUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(): List<String>? {
        return repository.getFavoriteVacanciesList()
    }
}