package com.badista.tisakmp.android.ui.auth.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.badista.tisakmp.android.R
import com.badista.tisakmp.android.common.theming.SocialAppTheme
import com.badista.tisakmp.android.common.components.CustomTextField
import com.badista.tisakmp.android.common.theming.ButtonHeight
import com.badista.tisakmp.android.common.theming.ExtraLargeSpacing
import com.badista.tisakmp.android.common.theming.LargeSpacing
import com.badista.tisakmp.android.common.theming.MavenBold
import com.badista.tisakmp.android.common.theming.MavenReguler
import com.badista.tisakmp.android.common.theming.MediumSpacing
import com.badista.tisakmp.android.common.theming.SmallSpacing
import com.badista.tisakmp.android.util.Validation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToHome: () -> Unit,
    onSignInClick: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    val context = LocalContext.current
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
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
                    bottom = ExtraLargeSpacing + LargeSpacing,
                    start = LargeSpacing + MediumSpacing,
                    end = LargeSpacing + MediumSpacing
                ),
            horizontalAlignment = Alignment.Start
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = 64.dp,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_logo_login),
                    contentDescription = null,
                    modifier = modifier.size(165.dp)
                )

                Text(
                    text = "TISA",
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontFamily = MavenBold,
                        fontWeight = FontWeight(1000),
                        color = Color.Black
                    )
                )

                Text(
                    text = "Topindoku Internal Sales App",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = MavenReguler,
                        fontWeight = FontWeight(500),
                        color = Color.Black
                    )
                )
            }

            Text(
                modifier = modifier
                    .padding(top = 42.dp, start = 4.dp),
                text = "ID / No. Handphone",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = MavenBold,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
            )

            CustomTextField(
                modifier = modifier.padding(top = 4.dp),
                value = uiState.username,
                onValueChange = onEmailChange,
                hint = R.string.masukan_id_topindoku,
                keyboardType = KeyboardType.Email,
                isIconStart = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = null
                    )
                }
            )

            Text(
                modifier = modifier
                    .padding(top = 16.dp, start = 4.dp),
                text = "Password",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = MavenBold,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
            )

            CustomTextField(
                modifier = modifier.padding(top = 4.dp),
                value = uiState.password,
                onValueChange = onPasswordChange,
                hint = R.string.masukan_password,
                keyboardType = KeyboardType.Password,
                isPasswordTextField = true,
                isIconStart = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock_grey),
                        contentDescription = null
                    )
                }
            )

            Spacer(modifier = modifier.padding(top = 16.dp))

            Button(
                onClick = {
                    onSignInClick()
                    uiState.username = ""
                    uiState.password = ""
                          },
//                onClick = {},
                modifier = modifier
                    .fillMaxWidth()
                    .height(ButtonHeight),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp
                ),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A79C),
                    contentColor = Color.White
                ),
                enabled = Validation.validateLogin(uiState.username, uiState.password)
            ) {
                Text(
                    text = stringResource(id = R.string.masuk),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = MavenBold,
                        fontWeight = FontWeight(500)
                    ),
                )
            }

            GoToSignup(modifier) {
                onNavigateToSignUp()
            }
        }

        if (uiState.isAuthenticating){
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

            if (uiState.authErrorMessage !== null) {
                Log.e("LOGIN_SCREEN", "${uiState.authErrorMessage}")
                Toast.makeText(context, "${uiState.authErrorMessage}", Toast.LENGTH_LONG).show()
            }
        }
    )
}

@Composable
fun GoToSignup(
    modifier: Modifier = Modifier,
    onNavigateToSignUp: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(SmallSpacing)
        ) {
            Text(
                text = "Don't have an account ?",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = MavenReguler,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
            )

            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = MavenReguler,
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.primary,
                ),
                modifier = modifier.clickable { onNavigateToSignUp() }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewLoginScreen() {
    SocialAppTheme {
        LoginScreen(
            uiState = LoginUiState(),
            onEmailChange = {},
            onPasswordChange = {},
            onNavigateToHome = {},
            onSignInClick = {},
            onNavigateToSignUp = {}
        )
    }
}