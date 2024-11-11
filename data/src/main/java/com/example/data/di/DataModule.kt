package com.example.data.di

import android.app.Application
import com.example.data.database.AppDatabase
import com.example.data.database.favoriteVacancies.FavoriteVacanciesDao
import com.example.data.database.user.UserDao
import com.example.data.mapper.DtoToEntityMapper
import com.example.data.network.ApiFactory
import com.example.data.network.ApiService
import com.example.data.repository.AuthorizationRepositoryImpl
import com.example.data.repository.VacancyRepositoryImpl
import com.example.domain.repository.AuthorizationRepository
import com.example.domain.repository.VacancyRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::VacancyRepositoryImpl) bind VacancyRepository::class
    singleOf(::AuthorizationRepositoryImpl) bind AuthorizationRepository::class
    single<ApiService> { ApiFactory.apiService }
    singleOf(::provideUserDao)
    singleOf(::provideFavoriteVacanciesDao)
    singleOf(::DtoToEntityMapper)
}

private fun provideUserDao(application: Application): UserDao {
    return AppDatabase.getInstance(application).userDao()
}

private fun provideFavoriteVacanciesDao(application: Application): FavoriteVacanciesDao {
    return AppDatabase.getInstance(application).favoriteVacanciesDao()
}