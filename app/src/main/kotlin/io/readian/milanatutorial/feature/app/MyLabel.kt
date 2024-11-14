// CommonComposables.kt
package io.readian.milanatutorial.feature.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun MyLabel(
    value: String,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 16.sp,
    color: Color = Color.Black
) {
    Text(
        text = value,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color
    )
}
