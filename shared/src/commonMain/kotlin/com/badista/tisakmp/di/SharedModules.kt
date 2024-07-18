package com.badista.tisakmp.di

import com.badista.tisakmp.auth.data.AuthService
import com.badista.tisakmp.auth.data.LoginRepositoryImpl
import com.badista.tisakmp.auth.domain.repository.LoginRepository
import com.badista.tisakmp.auth.domain.usecase.LoginUseCase
import com.badista.tisakmp.common.util.provideDispatcher
import org.koin.dsl.module

private val loginModule = module {
    single<LoginRepository> { LoginRepositoryImpl(get(), get()) }
    factory { AuthService() }
    factory { LoginUseCase() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getSharedModules() = listOf(loginModule, utilityModule)