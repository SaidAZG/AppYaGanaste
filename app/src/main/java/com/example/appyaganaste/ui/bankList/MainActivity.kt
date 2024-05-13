package com.example.appyaganaste.ui.bankList

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import com.example.appyaganaste.ui.bankDetail.BankDetailActivity
import com.example.appyaganaste.ui.theme.AppYaGanasteTheme
import java.io.Serializable

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            val intent = Intent(this@MainActivity, BankDetailActivity::class.java)

            AppYaGanasteTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    MainScreen(bankList = viewModel.bankListResponse, onClick = {
                        intent.putExtra("bank", it as Serializable)
                        startActivity(intent)
                    })
                    viewModel.getBanks()
                }
            }
        }
    }
}