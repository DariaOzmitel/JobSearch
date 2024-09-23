package com.example.domain.di

import com.example.domain.usecases.GetOfferListUseCase
import com.example.domain.usecases.GetVacancyListUseCase
import com.example.domain.usecases.GetVacancyUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetVacancyListUseCase)
    factoryOf(::GetOfferListUseCase)
    factoryOf(::GetVacancyUseCase)
}