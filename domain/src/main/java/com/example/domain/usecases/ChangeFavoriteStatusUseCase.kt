package com.example.domain.usecases

import com.example.domain.repository.JobSearchRepository

class ChangeFavoriteStatusUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(vacancyId: String) {
        return repository.changeFavoriteStatus(vacancyId)
    }
}