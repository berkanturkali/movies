package com.examle.movies.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.examle.movies.core.ui.R

val Poppins = FontFamily(
    Font(R.font.poppins_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.poppins_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_regular, weight = FontWeight.Normal),
    Font(R.font.poppins_thin, weight = FontWeight.Thin),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_extra_light, weight = FontWeight.ExtraLight),
    Font(
        R.font.poppins_extra_light_italic,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Italic
    ),
    Font(R.font.poppins_extra_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.poppins_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.poppins_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.poppins_extra_bold_italic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(R.font.poppins_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(R.font.poppins_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.poppins_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),
)

//region Small Typography
val SmallTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
        fontFamily = Poppins
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        fontFamily = Poppins
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontFamily = Poppins
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontFamily = Poppins
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        fontFamily = Poppins
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontFamily = Poppins
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontFamily = Poppins
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp,
        fontFamily = Poppins
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontFamily = Poppins
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontFamily = Poppins
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
        fontFamily = Poppins
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
        fontFamily = Poppins
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontFamily = Poppins
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontFamily = Poppins
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontFamily = Poppins
    )
)
//endregion

//region Medium & Large Typography
val MediumLargeTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 90.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
        fontFamily = Poppins
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 80.sp,
        lineHeight = 52.sp,
        fontFamily = Poppins
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 75.sp,
        lineHeight = 44.sp,
        fontFamily = Poppins
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 72.sp,
        lineHeight = 40.sp,
        fontFamily = Poppins
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 68.sp,
        lineHeight = 36.sp,
        fontFamily = Poppins
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 64.sp,
        lineHeight = 32.sp,
        fontFamily = Poppins
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 60.sp,
        lineHeight = 28.sp,
        fontFamily = Poppins
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 56.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp,
        fontFamily = Poppins
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 52.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontFamily = Poppins
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 48.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontFamily = Poppins
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 44.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
        fontFamily = Poppins
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 40.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
        fontFamily = Poppins
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 36.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontFamily = Poppins
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 32.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontFamily = Poppins
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 28.sp,
        lineHeight = 16.sp,
        fontFamily = Poppins
    )
)
//endregion