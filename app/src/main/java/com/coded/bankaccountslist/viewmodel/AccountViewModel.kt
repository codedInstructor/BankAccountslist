package com.coded.bankaccountslist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.coded.bankaccountslist.data.Account
import com.coded.bankaccountslist.repository.AccountsRepository

class AccountViewModel : ViewModel() {
    var accountsListState by mutableStateOf(AccountsRepository.dummyAccounts)
    var selectedAccount by mutableStateOf<Account?>(null)

    fun findAccount(name: String?): Account? {
        return accountsListState.find { it.name == name }
    }

    fun storeSelectedAccount(account: Account) {
        selectedAccount = account
    }

    fun deposit(amount: Double = 100.0) {
        var newAmount = selectedAccount?.amount?.plus(amount) ?: 0.0
        selectedAccount = selectedAccount?.copy(amount = newAmount)

    }
}