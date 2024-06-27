package com.example.appcomponentsadvanced

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appcomponentsadvanced.model.Mascota

@Composable
fun EjemploSimpleRecycler(){
    val lista = listOf("Luis", "Marcos", "Milagros", "Pablo", "German")
    LazyColumn {
        item { Text(text = "Primer item") }
        item { Text(text = "Primer item") }
        item { Text(text = "Primer item") }
        item { Text(text = "Primer item") }
        items(7){
            contador ->
            Text(text = "Item $contador")
        }
        items(lista){
            nombre ->
            Text(text = "Hola $nombre")
        }
    }
}

@Composable
fun EjemploRecyclerCard(){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(listarMascotas()){
            mascota -> 
            ItemRecycler(mascota = mascota)
        }
    }
}

@Composable
fun ItemRecycler(mascota: Mascota){
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = mascota.imagen)
                , contentDescription = "img",
                modifier = Modifier.width(200.dp),
                contentScale = ContentScale.Crop)
            Column(Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = mascota.nombre, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = mascota.raza)
            }
        }
    }
}
fun listarMascotas(): List<Mascota>{
    return listOf(
        Mascota("Pepa", "Cocker", 10,
            R.drawable.ic_launcher_background),
        Mascota("Hanna", "Husky", 7,
            R.drawable.ic_launcher_background),
        Mascota("Simba", "Pekines", 4,
            R.drawable.ic_launcher_background),
        Mascota("Zeus", "Cocker", 5,
            R.drawable.ic_launcher_background),
        Mascota("Pepa", "Cocker", 10,
            R.drawable.ic_launcher_background),
    )
}