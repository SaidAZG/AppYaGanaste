package com.example.appyaganaste.ui.bankList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appyaganaste.data.Bank
import com.example.appyaganaste.ui.theme.AppYaGanasteTheme

class MainActivity : ComponentActivity() {
    private val viewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppYaGanasteTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    BankList(bankList = viewModel.bankListResponse)
                    viewModel.getBanks()
                }
            }
        }
    }
}

@Composable
fun BankList(bankList: List<Bank>) {
    LazyColumn(Modifier.fillMaxSize()) {
        itemsIndexed(items = bankList){ index, bank ->
            BankListItem(bank = bank)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppYaGanasteTheme {
        val bank = Bank("Banco internacional",0,"","Nombre del Banco")
        BankListItem(bank = bank)
    }
}