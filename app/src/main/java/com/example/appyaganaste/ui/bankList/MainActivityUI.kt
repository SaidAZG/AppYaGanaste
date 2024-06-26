package com.example.appyaganaste.ui.bankList

import SearchBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appyaganaste.domain.model.Bank

@Composable
fun MainScreen(bankList: List<Bank>, onClick: (Bank) -> Unit, onFavoriteClick: (Bank) -> Unit) {
    var searchResult by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("") }
    var filteredList by remember { mutableStateOf(bankList) }

    Column {
        SearchBar(modifier = Modifier.fillMaxWidth()) { query ->
            searchText = query
            searchResult = "Realizando búsqueda: $query"
            filteredList = if (query.isNotEmpty()) {
                bankList.filter { it.bankName.contains(query, ignoreCase = true) }
            } else {
                bankList
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = searchResult)

        LazyColumn(Modifier.weight(1f)) {
            items(items = filteredList.ifEmpty { bankList }) { bank ->
                BankListItem(bank = bank, isFavorite = bank.isFavorite, onFavoriteClicked = {
                    onFavoriteClick(bank)
                }, onClick = {
                    onClick(bank)
                })
            }
        }
    }
}
