package com.example.domain.usecases

import com.example.domain.models.Offer
import com.example.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow

class GetOfferListUseCase(
    private val repository: VacancyRepository
) {
    suspend fun invoke(): Flow<List<Offer>> {
        return repository.getOfferList()
    }
}