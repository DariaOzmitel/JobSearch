package com.example.domain.repository

import com.example.domain.models.Offer
import com.example.domain.models.Vacancy

interface JobSearchRepository {
    suspend fun getVacancyList(): List<Vacancy>
    suspend fun getOfferList(): List<Offer>
}