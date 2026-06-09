package com.example.pawbuds.ui.features.swipe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pawbuds.ui.components.ImageCarousel

@Composable
fun ColumnScope.InfoDueno() {
    // array de dummy info para probar carrousel con strings en vez de imagenes reales
    val fotosDueno = listOf("foto1","foto2","foto3")

    ImageCarousel(fotosDueno, modifier = Modifier.fillMaxWidth().weight(1f))
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Nombre dueño, 25", fontWeight = FontWeight.Bold, fontSize = 20.sp)
    Text(text = "Descripción del dueño...", color = Color.Gray, fontSize = 14.sp)
}