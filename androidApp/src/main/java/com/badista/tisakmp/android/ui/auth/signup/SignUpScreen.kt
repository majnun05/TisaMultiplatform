package com.badista.tisakmp.android.ui.auth.signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.badista.tisakmp.android.R
import com.badista.tisakmp.android.common.theming.SocialAppTheme
import com.badista.tisakmp.android.common.components.CustomTextField
import com.badista.tisakmp.android.common.theming.ButtonHeight
import com.badista.tisakmp.android.common.theming.ExtraLargeSpacing
import com.badista.tisakmp.android.common.theming.LargeSpacing
import com.badista.tisakmp.android.common.theming.MediumSpacing
import com.badista.tisakmp.android.common.theming.SmallSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToHome: () -> Unit,
//    onSignUpClick: () -> Unit
) {
    val context = LocalContext.current
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(
                    color = if (isSystemInDarkTheme()) {
                        MaterialTheme.colorScheme.background
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                )
                .padding(
                    top = ExtraLargeSpacing + LargeSpacing,
                    bottom = LargeSpacing + MediumSpacing,
                    start = LargeSpacing + MediumSpacing,
                    end = LargeSpacing + MediumSpacing
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(LargeSpacing)
        ) {
            CustomTextField(
                value = uiState.username,
                onValueChange = onUsernameChange,
                hint = R.string.username_hint,
                isIconStart = {}
            )

            CustomTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
                hint = R.string.email_hint,
                keyboardType = KeyboardType.Email,
                isIconStart = {}
            )

            CustomTextField(
                value = uiState.password,
                onValueChange = onPasswordChange,
                hint = R.string.password_hint,
                keyboardType = KeyboardType.Password,
                isPasswordTextField = true,
                isIconStart = {}
            )

            Button(
//                onClick = { onSignUpClick() },
                onClick = {},
                modifier = modifier
                    .fillMaxWidth()
                    .height(ButtonHeight),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = stringResource(id = R.string.signup_button_hint))
            }

            GoToLogin(modifier) {
                onNavigateToLogin()
            }

            if (uiState.isAuthenticating) {
                CircularProgressIndicator()
            }
        }

        LaunchedEffect(
            key1 = uiState.authenticationSucceed,
            key2 = uiState.authErrorMessage,
            block = {
                if (uiState.authenticationSucceed) {
                    onNavigateToHome()
                }

                if (uiState.authErrorMessage != null) {
                    Toast.makeText(context, uiState.authErrorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}

@Composable
fun GoToLogin(
    modifier: Modifier = Modifier,
    onNavigateToLogin: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(SmallSpacing)
    ) {
        Text(
            text = "Have already an account ?",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Login",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier.clickable { onNavigateToLogin() }
        )
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SocialAppTheme {
        SignUpScreen(
            uiState = SignUpUiState(),
            onUsernameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onNavigateToLogin = {},
            onNavigateToHome = {},
//            onSignUpClick = {}
        )
    }
}