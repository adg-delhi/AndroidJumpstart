package com.adgdelhi.jumpstart

import android.app.Application
import com.adgdelhi.jumpstart.di.appModule
import com.adgdelhi.jumpstart.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

import timber.log.Timber

/**
 * Created by abhishek
 * on 05/04/16.
 */
open class ADGApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        setupDependencyInjection()
    }

    private fun setupDependencyInjection() {
        startKoin {
            androidLogger()
            androidContext(this@ADGApplication)
            // load properties from assets/koin.properties file
            androidFileProperties()
            modules(listOf(viewModelsModule, appModule))
        }
    }
}
