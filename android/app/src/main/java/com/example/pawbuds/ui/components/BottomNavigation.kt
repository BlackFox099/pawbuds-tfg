package com.example.pawbuds.ui.components

import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigation(
    currentScreen: String,
    onNavigateToSwipe: () -> Unit,
    onNavigateToChatList: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentScreen == "swipe",
            onClick = onNavigateToSwipe,
            icon = {BadgedBox({Badge(Modifier.size(6.dp).absoluteOffset(x = (1).dp, y = (2).dp)){}})
                {Icon(Icons.Default.Home, contentDescription = "Swipe")} },
            label = { Text("Swipe") }
        )
        NavigationBarItem(
            selected = currentScreen == "chats",
            onClick = onNavigateToChatList,
            icon = {BadgedBox({Badge(Modifier.size(6.dp).absoluteOffset(x = (1).dp, y = (2).dp)){}})
            {Icon(Icons.Default.Email, contentDescription = "Email")} },
            label = { Text("Chats") }
        )
        NavigationBarItem(
            selected = currentScreen == "profile",
            onClick = onNavigateToProfile,
            icon = {BadgedBox({Badge(Modifier.size(6.dp).absoluteOffset(x = (1).dp, y = (2).dp)){}})
            {Icon(Icons.Default.Person, contentDescription = "Profile")} },
            label = { Text("Perfil") }
        )
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    BottomNavigation(
        currentScreen = "swipe",
        onNavigateToSwipe = {},
        onNavigateToChatList = {},
        onNavigateToProfile = {}
    )
}
