package com.adgdelhi.jumpstart.di

import com.adgdelhi.jumpstart.api.ApiModule
import com.adgdelhi.jumpstart.utils.ADGLocalStorage
import com.adgdelhi.jumpstart.utils.MoshiProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val viewModelsModule = module {
}


val appModule = module {
    single { ADGLocalStorage(androidApplication(), "com.adgdelhi.jumpstart.sharedprefs") }
    single { MoshiProvider.provide() }
    single { ApiModule.providesApiService(get()) }
}