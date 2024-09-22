package com.example.jobsearch

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class JobSearchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@JobSearchApp)
            modules(listOf(dataModule, domainModule, uiModule))
        }
    }
}