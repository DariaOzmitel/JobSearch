package com.example.ui.di

import com.example.ui.mapper.DomainToUiMapper
import com.example.ui.screens.main.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::MainScreenViewModel)
    singleOf(::DomainToUiMapper)
}