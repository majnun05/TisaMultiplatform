package com.badista.tisakmp.android

import android.app.Application
import com.badista.tisakmp.android.di.appModule
import com.badista.tisakmp.di.getSharedModules
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // Log
        Napier.base(DebugAntilog())

        startKoin {
            modules(appModule + getSharedModules())
            androidContext(this@BaseApplication)
        }
    }
}