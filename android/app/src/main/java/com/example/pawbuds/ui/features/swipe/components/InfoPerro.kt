package com.example.pawbuds.ui.features.swipe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pawbuds.ui.components.ImageCarousel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun ColumnScope.InfoPerro() {
    //dummy array para simular diferentes perros
    val listaPerros = listOf("Toby", "Max", "Luna")
    var perroActualIndex by remember {mutableIntStateOf(0)}


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "${listaPerros[perroActualIndex]}, 3", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "Características...", color = Color.Gray, fontSize = 14.sp)
        }

        // Botón temporal para simular el cambio de perro
        if (listaPerros.size > 1) {
            Button(onClick = {
                perroActualIndex = (perroActualIndex + 1) % listaPerros.size
            }) {
                Text("Siguiente Perro")
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Carrusel de fotos del perro actual
    ImageCarousel(
        //dummy array de fotos de perro
        images = listOf("fotoPerro1", "fotoPerro2"),
        modifier = Modifier.fillMaxWidth().weight(1f)
    )
}