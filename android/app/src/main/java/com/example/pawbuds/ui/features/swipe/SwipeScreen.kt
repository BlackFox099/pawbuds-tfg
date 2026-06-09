package com.example.pawbuds.ui.features.swipe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pawbuds.ui.components.BottomNavigation
import com.example.pawbuds.ui.components.TopBar

import com.example.pawbuds.ui.features.swipe.components.SwipeCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeScreen(
    onNavigateToChatList: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToNotification: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Scaffold(
        topBar = { TopBar(
            onNavigateToNotification = onNavigateToNotification,
            onNavigateToSettings = onNavigateToSettings
        ) },
        bottomBar = {
            BottomNavigation(
                currentScreen = "swipe",
                onNavigateToSwipe = {},
                onNavigateToChatList = onNavigateToChatList,
                onNavigateToProfile = onNavigateToProfile
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            SwipeCard()
        }
    }
}