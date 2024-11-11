package com.example.domain.repository

import com.example.domain.models.Offer
import com.example.domain.models.Vacancy
import kotlinx.coroutines.flow.Flow

interface VacancyRepository {
    fun getVacancyList(): Flow<List<Vacancy>>
    fun getVacancy(id: String): Flow<Vacancy>
    fun getOfferList(): Flow<List<Offer>>
    suspend fun changeFavoriteStatus(vacancyId: String)
    fun getFavoriteVacanciesList(): Flow<List<Vacancy>>
}