package com.moldedbits.android

import android.app.Application

import timber.log.Timber

/**
 * Created by abhishek
 * on 05/04/16.
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}
