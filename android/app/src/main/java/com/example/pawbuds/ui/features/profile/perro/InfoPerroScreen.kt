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
fun InfoPerroScreen(onBackClick: () -> Unit) {
    val fotos = listOf("fotoPerro1") // Solo 1 foto de momento

    var nombre by remember { mutableStateOf("") }
    var tamano by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") } // Por simplicidad, un input de edad. Más adelante haremos el DatePicker si quieres.
    var energia by remember { mutableStateOf("") }

    var raza by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var castrado by remember { mutableStateOf("") }
    var alergias by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Info Perro") },
                navigationIcon = { IconButton(onClick = onBackClick) { Icon(Icons.Default.ArrowBack, "Volver") } }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Fotos de tu perro", fontWeight = FontWeight.Bold)
            PhotoEditor(photos = fotos, onAddPhotoClick = { /* TODO */ })

            HorizontalDivider()

            // OBLIGATORIOS
            OutlinedTextField(
                value = nombre, onValueChange = { nombre = it },
                label = { Text("Nombre *") }, modifier = Modifier.fillMaxWidth()
            )

            FormDropdown(
                label = "Tamaño *",
                options = listOf("Pequeño (1-10kg)", "Mediano (10-25kg)", "Grande (25-40kg)", "Gigante (+40kg)"),
                selectedOption = tamano, onOptionSelected = { tamano = it }
            )

            OutlinedTextField(
                value = edad, onValueChange = { edad = it },
                label = { Text("Edad (Años) *") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            FormDropdown(
                label = "Nivel de Energía *",
                options = listOf("Baja (Tranquilo)", "Media (Juguetón)", "Alta (Incansable)"),
                selectedOption = energia, onOptionSelected = { energia = it }
            )

            Divider()
            Text("Opcionales", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)

            // OPCIONALES
            FormDropdown(
                label = "Raza (Opcional)",
                options = listOf("Mestizo", "Golden Retriever", "Labrador", "Pastor Alemán", "Bulldog", "Caniche", "Otros..."),
                selectedOption = raza, onOptionSelected = { raza = it }
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Box(modifier = Modifier.weight(1f)) {
                    FormDropdown("Género", listOf("Macho", "Hembra"), genero, { genero = it })
                }
                Box(modifier = Modifier.weight(1f)) {
                    FormDropdown("Castrado", listOf("Sí", "No"), castrado, { castrado = it })
                }
            }

            OutlinedTextField(
                value = alergias, onValueChange = { alergias = it },
                label = { Text("Alergias o cuidados especiales (Opcional)") },
                modifier = Modifier.fillMaxWidth().height(100.dp),
                maxLines = 3
            )

            Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth().height(50.dp)) {
                Text("Guardar Perro")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}