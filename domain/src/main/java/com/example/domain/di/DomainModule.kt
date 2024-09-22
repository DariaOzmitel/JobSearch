package com.example.domain.di

import com.example.domain.GetVacancyListUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetVacancyListUseCase)
}