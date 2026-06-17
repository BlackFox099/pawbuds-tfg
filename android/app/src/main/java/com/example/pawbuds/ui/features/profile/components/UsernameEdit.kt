package com.example.pawbuds.ui.features.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UsernameEdit(
    username: String,
    onUsernameChange: (String) -> Unit,
    onConfirmEdit: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { nuevoTexto ->
                onUsernameChange(nuevoTexto)
            },
            singleLine = true,
            modifier = Modifier.weight(1f),
            trailingIcon = {
                IconButton(onClick = onConfirmEdit) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Guardar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        )
    }
}