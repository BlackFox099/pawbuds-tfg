package com.example.pawbuds.ui.features.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.pawbuds.ui.components.FormDropdown
import com.example.pawbuds.ui.features.profile.components.PhotoEditor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoDuenoScreen(onBackClick: () -> Unit) {
    // Estados (Simulando los datos actuales)
    val fotos = listOf("foto1", "foto2") // Simulamos 2 fotos ya subidas
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var tipoPaseo by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }
    var chuches by remember { mutableStateOf("") }
    var estiloPaseo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Info Dueño") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) { Icon(Icons.Default.ArrowBack, "Volver") }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()), // Permite hacer scroll si el form es largo
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado automático entre todos los elementos
        ) {
            Text("Tus Fotos", fontWeight = FontWeight.Bold)
            PhotoEditor(photos = fotos, onAddPhotoClick = { /* TODO */ })

            HorizontalDivider()

            // OBLIGATORIOS
            OutlinedTextField(
                value = nombre, onValueChange = { nombre = it },
                label = { Text("Nombre *") }, modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = edad, onValueChange = { edad = it },
                label = { Text("Edad *") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            FormDropdown(
                label = "Tipo de paseos *",
                options = listOf("Alrededor de casa", "Paseos largos por naturaleza", "Parque de perros", "Deporte/Correr"),
                selectedOption = tipoPaseo,
                onOptionSelected = { tipoPaseo = it }
            )

            Divider()
            Text("Opcionales", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)

            // OPCIONALES
            FormDropdown(
                label = "Horario preferido (Opcional)",
                options = listOf("Mañanas", "Mediodía", "Tardes", "Noches", "Flexible"),
                selectedOption = horario, onOptionSelected = { horario = it }
            )

            FormDropdown(
                label = "¿Sueles llevar chuches? (Opcional)",
                options = listOf("Siempre", "A veces", "Nunca", "Solo para mi perro"),
                selectedOption = chuches, onOptionSelected = { chuches = it }
            )

            FormDropdown(
                label = "Estilo de paseo (Opcional)",
                options = listOf("Con correa siempre", "Suelto en zonas seguras", "Entrenamiento activo"),
                selectedOption = estiloPaseo, onOptionSelected = { estiloPaseo = it }
            )

            OutlinedTextField(
                value = descripcion, onValueChange = { descripcion = it },
                label = { Text("Sobre mí (Opcional)") },
                modifier = Modifier.fillMaxWidth().height(120.dp),
                maxLines = 4
            )

            Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth().height(50.dp)) {
                Text("Guardar Perfil")
            }
            Spacer(modifier = Modifier.height(16.dp)) // Margen extra por si acaso al final
        }
    }
}