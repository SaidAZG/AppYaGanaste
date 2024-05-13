package com.example.appyaganaste.ui.bankList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.appyaganaste.data.Bank
import com.example.appyaganaste.ui.theme.AppYaGanasteTheme

@Composable
fun BankListItem(
    bank: Bank,
    isFavorite: Boolean,
    onFavoriteClicked: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Surface {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .clickable{onClick()}
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = bank.url,
                        builder = {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = bank.description,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f),
                    contentScale = ContentScale.Fit
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ){
                    Text(text = bank.bankName, style = MaterialTheme.typography.titleLarge)
                    Text(text = bank.description, style = MaterialTheme.typography.bodyMedium)
                }
                IconButton(
                    onClick = { onFavoriteClicked() },
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Toggle favorite"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppYaGanasteTheme {
        val bank = Bank("Banco internacional",0,"","Nombre del Banco")
        BankListItem(bank = bank, onClick = {}, isFavorite = false, onFavoriteClicked = {})
    }
}
