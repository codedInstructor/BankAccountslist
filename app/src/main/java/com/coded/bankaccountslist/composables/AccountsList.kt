package com.coded.bankaccountslist.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coded.bankaccountslist.data.Account


@Composable
fun AccountsList(
    accounts: List<Account>,
    modifier: Modifier = Modifier,
    onCardClicked: (String) -> Unit,

) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(accounts) { account ->
            AccountCard(account, onClick = onCardClicked)
        }
    }
}