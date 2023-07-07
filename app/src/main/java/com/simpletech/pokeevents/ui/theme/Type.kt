package com.simpletech.pokeevents.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

val Typography.KTitle: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(400),
        textAlign = TextAlign.Center
    )

val Typography.KLargeTitle: TextStyle
    get() = TextStyle(
        fontSize = 22.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight(400),
    )
val Typography.KMediumTitle: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(400),
    )

val Typography.KBodyRegular: TextStyle
    get() = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        textAlign = TextAlign.Center,
    )
val Typography.KBodyLarge: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight(500),
    )
val Typography.KButton: TextStyle
    get() = TextStyle(
        fontSize = 12.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(700),
    )

val Typography.KButtonLarge: TextStyle
    get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(500),
        letterSpacing = 0.32.sp,
    )