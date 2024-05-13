package com.example.appyaganaste.ui.bankList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appyaganaste.repo.ApiService
import com.example.appyaganaste.data.Bank
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var bankListResponse : List<Bank> by mutableStateOf(listOf())
    var errorMsg : String by mutableStateOf("")

    fun getBanks() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val bankList = apiService.getBanks()
                bankListResponse = bankList
            } catch (e: Exception) {
                errorMsg = e.message.toString()
            }
        }
    }
}