package com.coded.bankaccountslist.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coded.bankaccountslist.data.Account
import com.coded.bankaccountslist.viewmodel.AccountViewModel


@Composable
fun AccountsList(
    modifier: Modifier = Modifier,
    onCardClicked: (Account) -> Unit = {},
    accountViewModel: AccountViewModel = viewModel()
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(accountViewModel.accountsListState) { account ->
            AccountCard(account, onClick = onCardClicked)
        }
    }
}