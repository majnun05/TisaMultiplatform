package com.badista.tisakmp.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.badista.tisakmp.android.common.theming.MyApplicationTheme
import com.badista.tisakmp.android.navigation.SetupNavGraph
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val accessToken = viewModel.accessToken.collectAsStateWithLifecycle(initialValue = null)
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController, accessToken.value)
                }
            }
        }
    }
}
