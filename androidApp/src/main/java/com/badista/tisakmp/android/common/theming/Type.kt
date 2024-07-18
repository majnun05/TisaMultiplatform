package com.badista.tisakmp.android.common.theming

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.badista.tisakmp.android.R

val MavenBold = FontFamily(
    Font(R.font.mavenpro_medium, FontWeight.Medium),
    Font(R.font.mavenpro_semibold, FontWeight.SemiBold),
    Font(R.font.mavenpro_bold, FontWeight.Bold)
)
val MavenReguler = FontFamily(
    Font(R.font.mavenpro_regular, FontWeight.Light),
    Font(R.font.mavenpro_regular, FontWeight.Normal)
)