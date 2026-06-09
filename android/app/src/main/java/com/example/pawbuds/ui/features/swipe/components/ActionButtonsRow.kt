package com.example.pawbuds.ui.features.swipe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionButtonsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Dislike
        IconButton(
            onClick = { /* TODO: Dislike */ },
            modifier = Modifier.size(64.dp).clip(CircleShape).background(Color.White)
        ) {
            Icon(Icons.Default.Clear, contentDescription = "Nope", tint = Color.Red, modifier = Modifier.size(32.dp))
        }

        // Super Like
        IconButton(
            onClick = { /* TODO: Super Like */ },
            modifier = Modifier.size(48.dp).clip(CircleShape).background(Color.White)
        ) {
            Icon(Icons.Default.Star, contentDescription = "Super", tint = Color.Blue, modifier = Modifier.size(24.dp))
        }

        // Like
        IconButton(
            onClick = { /* TODO: Like */ },
            modifier = Modifier.size(64.dp).clip(CircleShape).background(Color.White)
        ) {
            Icon(Icons.Default.Favorite, contentDescription = "Like", tint = Color.Green, modifier = Modifier.size(32.dp))
        }
    }
}