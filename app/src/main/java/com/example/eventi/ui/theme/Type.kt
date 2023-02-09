package com.example.eventi.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.eventi.R

private val Inter : FontFamily = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_black),
    Font(R.font.inter_bold),
    Font(R.font.inter_light),
    Font(R.font.inter_extrabold),
    Font(R.font.inter_extralight),
    Font(R.font.inter_medium),
    Font(R.font.inter_semibold),
    Font(R.font.inter_thin),
)

val EventiTypography = Typography(
    h1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.W700,
        fontSize = 32.sp,
        color = PrimaryGray
    ),
    h2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        color = PrimaryGray
    ),
    body1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        color = PrimaryOrange
    ),
    subtitle1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        color = PrimaryGray
    ),
    subtitle2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        color = SecondaryGray
    ),
)