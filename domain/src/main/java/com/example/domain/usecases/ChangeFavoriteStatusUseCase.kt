package com.example.domain.usecases

import com.example.domain.repository.VacancyRepository

class ChangeFavoriteStatusUseCase(
    private val repository: VacancyRepository
) {
    suspend fun invoke(vacancyId: String) {
        return repository.changeFavoriteStatus(vacancyId)
    }
}