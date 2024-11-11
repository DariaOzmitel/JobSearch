package com.example.domain.usecases

import com.example.domain.models.Vacancy
import com.example.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow

class GetVacancyUseCase(
    private val repository: VacancyRepository
) {
    fun invoke(id: String): Flow<Vacancy> {
        return repository.getVacancy(id)
    }
}