package com.coded.bankaccountslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coded.bankaccountslist.composables.AccountCard
import com.coded.bankaccountslist.composables.AccountsList
import com.coded.bankaccountslist.composables.AccountsNavHost
import com.coded.bankaccountslist.composables.NavRoutesEnum
import com.coded.bankaccountslist.data.Account
import com.coded.bankaccountslist.ui.theme.BankAccountsListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankAccountsListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AccountsNavHost(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}