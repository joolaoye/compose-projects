package com.example.a30daysoffitness.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30daysoffitness.R


val MontSerratAlternates =  FontFamily(
    Font(R.font.montserrat_alternates_regular)
)

val Poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold)
)


val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = MontSerratAlternates,
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 28.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    ),


)

