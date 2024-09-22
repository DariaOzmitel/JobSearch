package com.example.data.network

import com.example.data.network.models.OffersDto
import com.example.data.network.models.VacanciesDto
import retrofit2.http.GET

interface ApiService {
    @GET("e4f85b350f2de699cec2ecfb66e2eee6f8a9db46/mockJson.json")
    suspend fun getVacancyList(): VacanciesDto

    @GET("e4f85b350f2de699cec2ecfb66e2eee6f8a9db46/mockJson.json")
    suspend fun getOfferList(): OffersDto
}