package com.example.pawbuds.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavGraph(
    startDestination: String = Screen.Login.route
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Pantalla de Login
        composable(route = Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Swipe.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // Pantalla Swipe
        composable(route = Screen.Swipe.route) {
            SwipeScreen(
                onNavigateToChatList = { navController.navigate(Screen.ChatList.route) },
                onNavigateToProfile = { navController.navigate(Screen.Profile.route) }
            )
        }

        // Pantalla de Chats
        composable(route = Screen.ChatList.route) {
            ChatListScreen(
                onChatClick = { chatId ->
                    navController.navigate(Screen.ChatDetail.createRoute(chatId))
                },
                onNavigateToSwipe = { navController.popBackStack() }
            )
        }

        // Chat individual
        composable(
            route = Screen.ChatDetail.route,
            arguments = listOf(navArgument("chatId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            ChatDetailScreen(
                chatId = chatId,
                onBackClick = { navController.popBackStack() }
            )
        }

        // Pantalla de perfil
        composable(route = Screen.Profile.route) {
            ProfileScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}


//provisional
@Composable fun LoginScreen(onLoginSuccess: () -> Unit) { /* Ya la rellenaremos */ }
@Composable fun SwipeScreen(onNavigateToChatList: () -> Unit, onNavigateToProfile: () -> Unit) { /* ... */ }
@Composable fun ChatListScreen(onChatClick: (String) -> Unit, onNavigateToSwipe: () -> Unit) { /* ... */ }
@Composable fun ChatDetailScreen(chatId: String, onBackClick: () -> Unit) { /* ... */ }
@Composable fun ProfileScreen(onBackClick: () -> Unit) { /* ... */ }