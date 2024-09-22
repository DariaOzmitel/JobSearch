package com.example.data.repository

import com.example.data.mapper.DtoToEntityMapper
import com.example.data.network.ApiService
import com.example.domain.models.Vacancy
import com.example.domain.repository.JobSearchRepository

class JobSearchRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: DtoToEntityMapper
) : JobSearchRepository {
    override suspend fun getVacancyList(): List<Vacancy> {
        val vacancyListDto = apiService.getVacancyList().vacancies
        return mapper.mapDtoListToEntityList(vacancyListDto) ?: emptyList()
    }
}