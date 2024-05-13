package com.example.appyaganaste.ui.bankDetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appyaganaste.data.Bank
import com.example.appyaganaste.ui.theme.AppYaGanasteTheme

class BankDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bank = intent.getSerializableExtra("bank") as Bank

        setContent {
            AppYaGanasteTheme {
                BankDetail(bank = bank)
            }
        }
    }
}