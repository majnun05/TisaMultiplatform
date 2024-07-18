package com.badista.tisakmp.android.ui.splash.view

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.badista.tisakmp.android.R
import com.badista.tisakmp.android.common.theming.MavenBold
import com.badista.tisakmp.android.common.theming.MavenReguler
import com.badista.tisakmp.android.navigation.Screen
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.delay

//@Destination(start = true)
@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 1f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(100)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }

    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(
    alpha: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = modifier.matchParentSize(),
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = "Logo Icon",
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = modifier.fillMaxSize().alpha(alpha = alpha),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier
                .padding(top = 64.dp),
            painter = painterResource(id = R.drawable.img_splashscreen),
            contentDescription = "Logo Icon",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = modifier
                .padding(top = 10.dp),
            text = "TISA",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = MavenBold,
                fontWeight = FontWeight(500),
                color = Color.White
            )
        )

        Text(
            text = "Topindoku Internal Sales App",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = MavenReguler,
                color = Color.White
            )
        )
    }

    Column(
        modifier = modifier.fillMaxSize().alpha(alpha = alpha),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Copyright © PT Topindoku Solusi Komunika 2023",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = MavenReguler,
                color = Color.White
            ),
            modifier = modifier.padding(bottom = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Splash(alpha = 1f)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewDark() {
    Splash(alpha = 1f)
}