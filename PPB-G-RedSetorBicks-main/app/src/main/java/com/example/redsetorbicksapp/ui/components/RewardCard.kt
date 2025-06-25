package com.example.redsetorbicksapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redsetorbicksapp.model.RewardItem

@Composable
fun RewardCard(reward: RewardItem, starPoints: Int, onRedeem: (RewardItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = reward.imageRes),
                contentDescription = reward.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = reward.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "${reward.requiredPoints} Star Points")
            }
            Button(
                onClick = { onRedeem(reward) },
                enabled = starPoints >= reward.requiredPoints
            ) {
                Text("Tukar Poin")
            }
        }
    }
}