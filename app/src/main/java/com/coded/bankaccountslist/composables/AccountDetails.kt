package com.coded.bankaccountslist.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coded.bankaccountslist.R
import com.coded.bankaccountslist.data.Account

@Composable
fun AccountDetails(account: Account, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = account.name)
        Text(text = "${account.amount} ${account.currency}")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.deposit))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.withdraw))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountDetailsPreview() {
    AccountDetails(Account("Preview", amount = 12.4, currency = "KWD"))

}