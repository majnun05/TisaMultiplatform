package com.badista.tisakmp.android.ui

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import com.badista.tisakmp.android.common.datastore.LoginDatastore
import com.badista.tisakmp.android.common.datastore.toLoginData
import kotlinx.coroutines.flow.map

class MainActivityViewModel(
    private val loginDatastore: DataStore<LoginDatastore>
): ViewModel() {
    val accessToken = loginDatastore.data.map { it.toLoginData().access_token }
}