package com.example.domain.repository

import com.example.domain.models.Vacancy

interface JobSearchRepository {
    suspend fun getVacancyList(): List<Vacancy>
}