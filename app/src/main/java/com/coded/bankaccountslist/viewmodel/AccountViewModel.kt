package com.coded.bankaccountslist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.coded.bankaccountslist.data.Account
import com.coded.bankaccountslist.repository.AccountsRepository

class AccountViewModel : ViewModel() {
    var accountsListState by mutableStateOf(AccountsRepository.dummyAccounts)
        private set
    var selectedAccount by mutableStateOf<Account?>(null)
        private set

    fun findAccount(name: String?): Account? {
        return accountsListState.find { it.name == name }
    }

    fun selectAccount(account: Account) {
        selectedAccount = account
    }

    private fun updateAccountsListState() {
        selectedAccount?.let { selected ->
            accountsListState = accountsListState
                .map { if (it.name == selected.name) selected else it }
        }
    }


    fun deposit(amount: Double = 100.0) {
        selectedAccount = selectedAccount?.let {
            it.copy(amount = it.amount + amount)
        }
        updateAccountsListState()

    }

    fun withdraw(amount: Double = 100.0) {
        selectedAccount = selectedAccount?.let {
            it.copy(amount = it.amount - amount)
        }
        updateAccountsListState()
    }
}