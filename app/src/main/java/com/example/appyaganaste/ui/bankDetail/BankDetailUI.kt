package com.example.appyaganaste.ui.bankDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.appyaganaste.domain.model.Bank

class BankPreviewParameterProvider : PreviewParameterProvider<Bank> {
    override val values: Sequence<Bank> = sequenceOf(
        Bank("Bank A Description", 1, "", "Bank A")
    )
}

@Preview
@Composable
fun BankDetail(@PreviewParameter(BankPreviewParameterProvider::class) bank : Bank) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = bank.bankName,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = bank.description,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = "${if (bank.age > 1) "${bank.age} años" else "${bank.age} año"} en el mercado",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}