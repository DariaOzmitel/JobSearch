package com.example.data.repository

import com.example.data.database.user.UserDao
import com.example.data.database.user.UserDbModel
import com.example.data.mapper.DtoToEntityMapper
import com.example.data.network.ApiService
import com.example.domain.models.Offer
import com.example.domain.models.Vacancy
import com.example.domain.repository.JobSearchRepository

class JobSearchRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: DtoToEntityMapper,
    private val userDao: UserDao
) : JobSearchRepository {
    override suspend fun getVacancyList(): List<Vacancy> {
        val vacancyListDto = apiService.getVacancyList().vacancies
        return mapper.mapVacancyDtoListToEntityList(vacancyListDto) ?: emptyList()
    }

    override suspend fun getVacancy(id: String): Vacancy {
        val vacancyList = getVacancyList()
        return vacancyList.find { it.id == id }
            ?: throw NoSuchElementException("Vacancy with id $id not found")
    }

    override suspend fun getOfferList(): List<Offer> {
        val offerListDto = apiService.getOfferList().offers
        return mapper.mapOfferDtoListToEntityList(offerListDto) ?: emptyList()
    }

    override suspend fun addUser(mail: String) {
        userDao.addUser(UserDbModel(mail))
    }

    override suspend fun checkAuthorization(): Boolean {
        return userDao.checkAuthorization() != null
    }
}