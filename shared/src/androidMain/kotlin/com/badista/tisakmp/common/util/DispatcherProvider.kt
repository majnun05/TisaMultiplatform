package com.badista.tisakmp.common.util

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class AndroidDispatcher: DispatcherProvider{

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main


    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

}

internal actual fun provideDispatcher(): DispatcherProvider = AndroidDispatcher()

actual fun initLogger() {
    Napier.base(DebugAntilog())
}