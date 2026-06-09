package com.example.pawbuds.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onNavigateToNotification: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    TopAppBar (
        title = { Text("PawBuds") },
        actions = {
            IconButton(onClick = onNavigateToNotification) {
                BadgedBox({ Badge { Text("1") } }) {Icon(Icons.Outlined.Notifications, contentDescription = "Notificaciones") }
            }
            IconButton(onClick = onNavigateToSettings) {
                Icon(Icons.Outlined.Settings, contentDescription = "Configuración")
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(
        onNavigateToNotification = {},
        onNavigateToSettings = {}
    )
}