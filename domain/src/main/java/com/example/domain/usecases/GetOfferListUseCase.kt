package com.example.domain.usecases

import com.example.domain.models.Offer
import com.example.domain.repository.JobSearchRepository

class GetOfferListUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(): List<Offer> {
        return repository.getOfferList()
    }
}