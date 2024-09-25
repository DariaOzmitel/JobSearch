package com.example.domain.usecases

import com.example.domain.repository.JobSearchRepository

class DeleteFromFavoritesUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(vacancyId: String) {
        return repository.deleteFromFavorites(vacancyId)
    }
}