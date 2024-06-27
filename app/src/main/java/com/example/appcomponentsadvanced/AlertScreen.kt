package com.example.appcomponentsadvanced

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun EjemploCustomDialog(
    mostrar: Boolean,
    onDismiss: () -> Unit
) {
    if (mostrar) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                TituloDialog(texto = "Título Dialog Prueba")
                ItemDialog(texto = "Luis Angel Salvatierra",
                    drawable = R.drawable.ic_launcher_background)
                ItemDialog(texto = "Gabriel Santos Chavez",
                    drawable = R.drawable.ic_launcher_foreground)
                ItemDialog(texto = "Teresa Julian Portocarrero",
                    drawable = R.drawable.ic_launcher_background)
                ItemDialog(texto = "Ivan Bardalez Torres",
                    drawable = R.drawable.ic_launcher_foreground)
                ItemDialog(texto = "Nuevo integrante..",
                    drawable = R.drawable.ic_launcher_background)
            }
        }
    }
}

@Composable
fun ItemDialog(texto: String, @DrawableRes drawable: Int) {
    TextButton(onClick = { }, Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "img",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Text(
                text = texto,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun TituloDialog(
    texto: String, modifier:
    Modifier = Modifier.padding(bottom = 12.dp)
) {
    Text(
        text = texto, fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp, modifier = modifier
    )
}

@Composable
fun EjemploDialogBasic(
    mostrar: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (mostrar) {
        AlertDialog(onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Salir")
                }
            },
            text = { Text(text = "Hola mundo, Alert Dialog") },
            title = { Text(text = "Título") })
    }
}