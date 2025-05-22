package com.coded.bankaccountslist.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coded.bankaccountslist.viewmodel.AccountViewModel

enum class NavRoutesEnum(val value: String) {
    NAV_ROUTE_ACCOUNTS_LIST("accountsList"),
    NAV_ROUTE_ACCOUNT_DETAILS("accountDetails");
}

@Composable
fun AccountsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavRoutesEnum.NAV_ROUTE_ACCOUNTS_LIST.value,
    accountViewModel: AccountViewModel = viewModel()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavRoutesEnum.NAV_ROUTE_ACCOUNTS_LIST.value) {
            AccountsList(
                accountViewModel = accountViewModel,
                onCardClicked = { account ->
                    accountViewModel.selectAccount(account)
                    navController.navigate(NavRoutesEnum.NAV_ROUTE_ACCOUNT_DETAILS.value)
                }
            )
        }

        composable(NavRoutesEnum.NAV_ROUTE_ACCOUNT_DETAILS.value) {
            AccountDetails(
                accountViewModel = accountViewModel
            )
        }
    }
}