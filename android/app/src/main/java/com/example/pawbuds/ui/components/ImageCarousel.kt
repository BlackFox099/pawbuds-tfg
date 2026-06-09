package com.example.pawbuds.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ImageCarousel(
    images: List<String>,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray.copy(alpha = 0.3f))
    ) {
        // Aquí irá la imagen real con Coil en el futuro:
        // AsyncImage(model = images[currentIndex], ...)
        Text(
            text = "Foto ${currentIndex + 1} de ${images.size}",
            modifier = Modifier.align(Alignment.Center),
            color = Color.DarkGray
        )

        // Capa invisible encima para detectar los "taps"
        Row(modifier = Modifier.fillMaxSize()) {
            // Mitad izquierda (Vuelve atrás)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        if (currentIndex > 0) currentIndex--
                    }
            )
            // Mitad derecha (Avanza)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        if (currentIndex < images.size - 1) currentIndex++
                    }
            )
        }
    }
}