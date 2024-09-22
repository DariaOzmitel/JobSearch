package com.example.data.network

import com.example.data.network.models.VacanciesDto
import retrofit2.http.GET

interface ApiService {
    @GET("663b3cdef4185ed4671914a159e5b6b182286ebb/mockJson.json")
    suspend fun getVacancyList(): VacanciesDto
}