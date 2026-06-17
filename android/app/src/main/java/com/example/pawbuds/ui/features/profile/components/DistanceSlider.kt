package com.example.pawbuds.ui.features.profile.components

import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun DistanceSlider(){
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Text(text = "Distancia: ${sliderPosition.toInt()} km")
    Slider(value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        steps = 0)
}