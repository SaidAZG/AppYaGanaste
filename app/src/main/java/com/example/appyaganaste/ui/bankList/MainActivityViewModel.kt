package com.example.appyaganaste.ui.bankList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appyaganaste.repo.ApiService
import com.example.appyaganaste.data.Bank
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var bankListResponse: MutableState<List<Bank>> = mutableStateOf(emptyList())
        private set
    var errorMsg: MutableState<String> = mutableStateOf("")

    fun getBanks() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val bankList = apiService.getBanks()
                bankListResponse.value = bankList.toMutableList()
            } catch (e: Exception) {
                errorMsg.value = e.message.toString()
            }
        }
    }

    fun updateFavorite(selectedBank: Bank) {
        bankListResponse.value = bankListResponse.value.map { bank ->
            if (bank.bankName == selectedBank.bankName) {
                bank.copy(isFavorite = !bank.isFavorite)
            } else {
                bank
            }
        }
    }
}