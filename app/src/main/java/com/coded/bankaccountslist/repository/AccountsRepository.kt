package com.coded.bankaccountslist.repository

import com.coded.bankaccountslist.data.Account

object AccountsRepository {
    var dummyAccounts = listOf(
        Account(
            "Mishal Account",
            "KWD",
            1055000.2223
        ), Account(
            "Asma Mishal Account",
            "SAR",
            1000.2284673
        ), Account(
            "Ali Account",
            "KWD",
            10.250
        ), Account(
            "Sarah Account",
            "KWD",
            10000000000.2223
        )
    )
}