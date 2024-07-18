package com.badista.tisakmp.android.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.badista.tisakmp.android.common.datastore.LoginDatastoreSerializer
import com.badista.tisakmp.android.ui.MainActivityViewModel
import com.badista.tisakmp.android.ui.auth.login.LoginViewModel
import com.badista.tisakmp.android.ui.auth.signup.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { SignUpViewModel() }
    viewModel { MainActivityViewModel(get()) }

    single {
        DataStoreFactory.create(
            serializer = LoginDatastoreSerializer,
            produceFile = {
                androidContext().dataStoreFile(
                    fileName = "login_datastore"
                )
            }
        )
    }
}