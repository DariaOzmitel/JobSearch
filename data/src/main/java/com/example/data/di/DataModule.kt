package com.example.data.di

import android.app.Application
import com.example.data.database.AppDatabase
import com.example.data.database.user.UserDao
import com.example.data.mapper.DtoToEntityMapper
import com.example.data.network.ApiFactory
import com.example.data.network.ApiService
import com.example.data.repository.JobSearchRepositoryImpl
import com.example.domain.repository.JobSearchRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::JobSearchRepositoryImpl) bind JobSearchRepository::class
    single<ApiService> { ApiFactory.apiService }
    single { provideUserInfoDao(get()) }
    singleOf(::DtoToEntityMapper)
}

fun provideUserInfoDao(application: Application): UserDao {
    return AppDatabase.getInstance(application).userDao()
}