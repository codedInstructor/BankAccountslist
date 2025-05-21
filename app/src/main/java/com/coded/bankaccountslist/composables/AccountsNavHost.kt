package com.coded.bankaccountslist.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coded.bankaccountslist.repository.AccountsRepository

enum class NavRoutesEnum(val value: String) {
    NAV_ROUTE_ACCOUNTS_LIST("accountsList"),
    NAV_ROUTE_ACCOUNT_DETAILS("accountDetails");
}

@Composable
fun AccountsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "accountsList"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavRoutesEnum.NAV_ROUTE_ACCOUNTS_LIST.value) {
            var accountsListState by remember { mutableStateOf(AccountsRepository.dummyAccounts) }
            AccountsList(
                accountsListState,
                onCardClicked = { name -> navController.navigate("${NavRoutesEnum.NAV_ROUTE_ACCOUNT_DETAILS.value}/${name}") }
            )
        }

        composable("${NavRoutesEnum.NAV_ROUTE_ACCOUNT_DETAILS.value}/{accountName}") {
            val accountName = it.arguments?.getString("accountName")
            var account = AccountsRepository.dummyAccounts.find { it.name == accountName }
            if (account != null) {
                AccountDetails(
                    account = account
                )
            }
        }
    }
}