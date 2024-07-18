package com.badista.tisakmp.common.util

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class IOSDispatcher: DispatcherProvider {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.Default

}

internal actual fun provideDispatcher(): DispatcherProvider = IOSDispatcher()

actual fun initLogger() {
    Napier.base(DebugAntilog())
}