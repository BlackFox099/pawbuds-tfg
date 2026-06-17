package com.example.pawbuds.ui.features.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pawbuds.ui.components.BottomNavigation
import com.example.pawbuds.ui.components.TopBar
import com.example.pawbuds.ui.features.profile.components.DistanceSlider
import com.example.pawbuds.ui.features.profile.components.PasswordEdit
import com.example.pawbuds.ui.features.profile.components.PasswordFixed
import com.example.pawbuds.ui.features.profile.components.ProfilePic
import com.example.pawbuds.ui.features.profile.components.UsernameEdit
import com.example.pawbuds.ui.features.profile.components.UsernameFixed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onNavigateToSwipe: () -> Unit,
    onNavigateToChatList: () -> Unit,
    onNavigateToNotification: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToInfoDueno: () -> Unit, // Función para ir a la pantalla del Dueño
    onNavigateToInfoPerro: () -> Unit,  // Función para ir a la pantalla del Perro
    onNavigateToLogin: () -> Unit
) {
    var username by remember { mutableStateOf("Nombre de Usuario") }
    var isEditingUsername by remember { mutableStateOf(false) }
    var isEditingPassword by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar(
                onNavigateToNotification = onNavigateToNotification,
                onNavigateToSettings = onNavigateToSettings
            )
        },
        bottomBar = {
            BottomNavigation(
                currentScreen = "profile",
                onNavigateToSwipe = onNavigateToSwipe,
                onNavigateToChatList = onNavigateToChatList,
                onNavigateToProfile = { /* Ya estamos aquí */ }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- FOTO DE PERFIL PRINCIPAL ---
            ProfilePic()

            Spacer(modifier = Modifier.height(16.dp))

            if(isEditingUsername){
                UsernameEdit(username = username,
                    onUsernameChange = { username = it },
                    onConfirmEdit = { isEditingUsername = false })
            } else{
                UsernameFixed(username = username,
                    onEditingUsername = {isEditingUsername = true})
            }

            Spacer(modifier = Modifier.height(10.dp))

            if(isEditingPassword){
                PasswordEdit(onOldPassword = {},
                    onNewPassword = {},
                    onNewPassword2 = {},
                    onConfirmEdit = { isEditingPassword = false })
            } else{
                PasswordFixed(onEditingPassword = {isEditingPassword = true})
            }

            Spacer(modifier = Modifier.height(40.dp))

            DistanceSlider()

            Spacer(modifier = Modifier.height(40.dp))

            // --- BOTONES DE NAVEGACIÓN A SUB-PERFILES ---

            // Botón: Info Dueño
            ElevatedButton(
                onClick = onNavigateToInfoDueno,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(Icons.Default.Person, contentDescription = "Info Dueño")
                Spacer(modifier = Modifier.width(12.dp))
                Text("Gestionar Info Dueño", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón: Info Perro
            ElevatedButton(
                onClick = onNavigateToInfoPerro,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(Icons.Default.Star, contentDescription = "Info Perro")
                Spacer(modifier = Modifier.width(12.dp))
                Text("Gestionar Info Perro", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }

            // Espacio flexible para empujar lo que quieras poner abajo del todo
            Spacer(modifier = Modifier.weight(1f))

            //Boton cerrar sesion
            Button(onClick=onNavigateToLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text("Cerrar Sesión", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}