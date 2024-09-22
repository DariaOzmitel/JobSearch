package com.example.ui.di

import com.example.ui.mapper.DomainToUiMapper
import com.example.ui.screens.main.MainScreenViewModel
import com.example.ui.screens.vacanciesByMatch.VacancyByMatchScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::VacancyByMatchScreenViewModel)
    singleOf(::DomainToUiMapper)
}