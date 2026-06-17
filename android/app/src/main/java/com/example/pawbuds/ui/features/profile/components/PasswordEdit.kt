package com.example.pawbuds.ui.features.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun PasswordEdit(
    onOldPassword: (String) -> Unit,
    onNewPassword: (String) -> Unit,
    onNewPassword2: (String) -> Unit,
    onConfirmEdit: () -> Unit
){

    var oldPassword by remember { mutableStateOf("") }
    var newPassword1 by remember { mutableStateOf("") }
    var newPassword2 by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        OutlinedTextField(
            value = oldPassword,
            onValueChange = { onOldPassword(oldPassword) },
            label = { Text("Contraseña actual") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            readOnly = false,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = newPassword1,
            onValueChange = { onNewPassword(newPassword1) },
            label = { Text("Nueva contraseña") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            readOnly = false,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = newPassword2,
            onValueChange = { onNewPassword2(newPassword2) },
            label = { Text("Repetir nueva contraseña") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            readOnly = false,
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = onConfirmEdit){
            Text("Guardar")
        }

    }
}