package com.simpletech.pokeevents.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.simpletech.pokeevents.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

private val appFont = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.robotobold,
            weight = FontWeight.Bold

        ),
        Font(
            resId = R.font.robotoblack,
            weight = FontWeight.Black
        ),
        Font(
            resId = R.font.robotolight,
            weight = FontWeight.Light
        ),
        Font(
            resId = R.font.robotomedium,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.robotothin,
            weight = FontWeight.Thin
        )
    )
)


val Typography.KTitle: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontFamily = appFont,
        fontWeight = FontWeight(400)
    )

val Typography.KLargeTitle: TextStyle
    get() = TextStyle(
        fontSize = 22.sp,
        lineHeight = 30.sp,
        fontFamily = appFont,
        fontWeight = FontWeight(400),
    )
val Typography.KMediumTitle: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontFamily = appFont,
        fontWeight = FontWeight(400),
    )

val Typography.KBodyRegular: TextStyle
    get() = TextStyle(
        fontSize = 14.sp,
        fontFamily = appFont,
        fontWeight = FontWeight(400),
        lineHeight = 16.sp
    )
val Typography.KBodyLarge: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
        lineHeight = 30.sp,
        fontFamily = appFont,
        fontWeight = FontWeight(500),
    )
val Typography.KButton: TextStyle
    get() = TextStyle(
        fontSize = 12.sp,
        lineHeight = 24.sp,
        fontFamily = appFont,
        fontWeight = FontWeight(700),
    )

val Typography.KButtonLarge: TextStyle
    get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = appFont,
        fontWeight = FontWeight(500),
        letterSpacing = 0.32.sp,
    )