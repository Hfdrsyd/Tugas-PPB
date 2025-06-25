package com.example.redsetorbicksapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redsetorbicksapp.model.MenuItem

@Composable
fun MenuCard(menu: MenuItem, onAddClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Gambar Item Menu
            Image(
                painter = painterResource(id = menu.imageRes),
                contentDescription = menu.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(105.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )

//            Spacer(modifier = Modifier.height(8.dp))

            // Nama Item Menu
            Text(
                text = menu.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(4.dp))

            // Harga Item Menu
            Text(text = "Rp${menu.price}", style = MaterialTheme.typography.bodyMedium)

//            Spacer(modifier = Modifier.height(8.dp))

            // Tombol Tambahkan Item Menu
            Button(
                onClick = onAddClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("+ Tambah")
            }
        }
    }
}