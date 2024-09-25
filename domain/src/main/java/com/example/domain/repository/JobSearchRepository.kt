package com.example.domain.repository

import com.example.domain.models.Offer
import com.example.domain.models.Vacancy

interface JobSearchRepository {
    suspend fun getVacancyList(): List<Vacancy>
    suspend fun getVacancy(id: String): Vacancy
    suspend fun getOfferList(): List<Offer>
    suspend fun addUser(mail: String)
    suspend fun checkAuthorization(): Boolean
    suspend fun changeFavoriteStatus(vacancyId: String)
    suspend fun getFavoriteVacanciesList(): List<Vacancy>
}