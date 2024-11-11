package com.example.domain.usecases

import com.example.domain.models.Vacancy
import com.example.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow

class GetVacancyListUseCase(
    private val repository: VacancyRepository
) {
    fun invoke(): Flow<List<Vacancy>> {
        return repository.getVacancyList()
    }
}