package com.example.appyaganaste.ui.bankList

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import com.example.appyaganaste.ui.bankDetail.BankDetailActivity
import com.example.appyaganaste.ui.theme.AppYaGanasteTheme
import java.io.Serializable

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val intent = Intent(this@MainActivity, BankDetailActivity::class.java)

        setContent {
            AppYaGanasteTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val bankList by viewModel.bankListResponse
                    MainScreen(
                        bankList = bankList,
                        onClick = {
                            intent.putExtra("bank", it as Serializable)
                            startActivity(intent)
                        },
                        onFavoriteClick = { bank ->
                            viewModel.updateFavorite(bank)
                        }
                    )
                }
            }
        }
        viewModel.getBanks()
    }
}