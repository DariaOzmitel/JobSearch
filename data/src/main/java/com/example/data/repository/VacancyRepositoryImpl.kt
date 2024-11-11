package com.example.data.repository

import com.example.data.database.favoriteVacancies.FavoriteVacanciesDao
import com.example.data.database.favoriteVacancies.FavoriteVacanciesDbModel
import com.example.data.mapper.DtoToEntityMapper
import com.example.data.network.ApiService
import com.example.domain.models.Offer
import com.example.domain.models.Vacancy
import com.example.domain.repository.VacancyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class VacancyRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: DtoToEntityMapper,
    private val favoriteVacanciesDao: FavoriteVacanciesDao,
) : VacancyRepository {
    override fun getVacancyList(): Flow<List<Vacancy>> {
        val vacancyListDto = flow {
            emit(apiService.getVacancyList().vacancies)
        }.flowOn(Dispatchers.IO)

        val favoriteVacanciesList = getFavoriteVacanciesListFromDb()

        return combine(
            vacancyListDto,
            favoriteVacanciesList
        ) { vacanciesDto, favoriteVacancies ->
            mapper.mapVacancyDtoListToEntityList(vacanciesDto, favoriteVacancies).orEmpty()
        }
    }

    override fun getVacancy(id: String): Flow<Vacancy> {
        val vacancyList = getVacancyList()
        return vacancyList.map {
            it.firstOrNull { vacancy -> vacancy.id == id }
                ?: throw NoSuchElementException("Vacancy with id $id not found")
        }
    }

    override fun getOfferList(): Flow<List<Offer>> {
        val offerListDto = flow {
            emit(apiService.getOfferList().offers)
        }.flowOn(Dispatchers.IO)
        return offerListDto.map {
            mapper.mapOfferDtoListToEntityList(it).orEmpty()
        }
    }

    override suspend fun changeFavoriteStatus(vacancyId: String) {
        val isVacancyFavorite = favoriteVacanciesDao.isVacancyFavorite(vacancyId).first()
        when (isVacancyFavorite) {
            true -> {
                deleteFromFavorites(vacancyId)
            }

            false -> {
                addFavoriteVacancy(vacancyId)
            }
        }
    }

    override fun getFavoriteVacanciesList(): Flow<List<Vacancy>> =
        getVacancyList().map { vacancies ->
            vacancies.filter { it.isFavorite }
        }

    private suspend fun addFavoriteVacancy(vacancyId: String) {
        favoriteVacanciesDao.addFavoriteVacancy(FavoriteVacanciesDbModel(vacancyId))
    }

    private suspend fun deleteFromFavorites(vacancyId: String) {
        favoriteVacanciesDao.deleteFromFavorites(vacancyId)
    }

    private fun getFavoriteVacanciesListFromDb(): Flow<List<String>> =
        favoriteVacanciesDao.getFavoriteVacanciesList().map { vacanciesDbModelList ->
            vacanciesDbModelList.map { it.vacancyId }
        }

}