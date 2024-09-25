package com.example.domain.di

import com.example.domain.usecases.AddFavoriteVacancyUseCase
import com.example.domain.usecases.AddUserUseCase
import com.example.domain.usecases.ChangeFavoriteStatusUseCase
import com.example.domain.usecases.CheckAuthorizationUseCase
import com.example.domain.usecases.DeleteFromFavoritesUseCase
import com.example.domain.usecases.GetFavoriteVacanciesListUseCase
import com.example.domain.usecases.GetOfferListUseCase
import com.example.domain.usecases.GetVacancyListUseCase
import com.example.domain.usecases.GetVacancyUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetVacancyListUseCase)
    factoryOf(::GetOfferListUseCase)
    factoryOf(::GetVacancyUseCase)
    factoryOf(::AddUserUseCase)
    factoryOf(::CheckAuthorizationUseCase)
    factoryOf(::AddFavoriteVacancyUseCase)
    factoryOf(::DeleteFromFavoritesUseCase)
    factoryOf(::ChangeFavoriteStatusUseCase)
    factoryOf(::GetFavoriteVacanciesListUseCase)
}