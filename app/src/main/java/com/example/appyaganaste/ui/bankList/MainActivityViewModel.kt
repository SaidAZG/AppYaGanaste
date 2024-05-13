package com.example.appyaganaste.ui.bankList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appyaganaste.AppYaGanaste
import com.example.appyaganaste.data.Bank
import com.example.appyaganaste.data.database.entity.BankEntity
import com.example.appyaganaste.repo.ApiService
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val dao = AppYaGanaste.instance.db.getBankDao()
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
                viewModelScope.launch {
                    if (!bank.isFavorite){
                        dao.insert(bank.toBankEntity())
                    } else {
                        dao.delete(bank.toBankEntity())
                    }
                }
                bank.copy(isFavorite = !bank.isFavorite)
            } else {
                bank
            }
        }
    }
}