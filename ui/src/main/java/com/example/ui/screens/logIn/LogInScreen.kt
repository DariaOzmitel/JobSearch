package com.example.ui.screens.logIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.elements.text.TextTitle2
import com.example.ui.molecules.cards.EmployeeSearchCard
import com.example.ui.molecules.cards.JobSearchCard
import com.example.ui.theme.JobSearchTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun LogInScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    onButtonClickListener: (String) -> Unit,
) {
    val viewModel: LogInScreenViewModel = koinViewModel()
    val mail by viewModel.getLogInMail().collectAsStateWithLifecycle()
    LogInScreenContent(
        modifier = modifier,
        innerPadding = innerPadding,
        mail = mail,
        onButtonClickListener = {
        onButtonClickListener(
            mail
        )
    }) {
        viewModel.updateMail(it)
    }
}

@Composable
private fun LogInScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    mail: String,
    onButtonClickListener: () -> Unit,
    onValueChangeListener: (String) -> Unit,
) {
    Column(
        modifier = modifier.padding(
            top = innerPadding.calculateTopPadding() + 32.dp,
            bottom = innerPadding.calculateBottomPadding(),
            start = 16.dp,
            end = 16.dp
        )
    ) {
        TextTitle2(
            text = stringResource(id = R.string.log_in_to_personal_account),
            color = JobSearchTheme.colors.basicWhite
        )
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            JobSearchCard(
                modifier = Modifier.padding(bottom = 16.dp),
                displayText = mail,
                isButtonEnabled = mail.isNotEmpty(),
                onButtonClickListener = onButtonClickListener
            ) {
                onValueChangeListener(it)
            }
            EmployeeSearchCard()
        }
    }
}

@Preview
@Composable
private fun LogInScreenPreview() {
    LogInScreenContent(innerPadding = PaddingValues(0.dp), mail = "", onButtonClickListener = {}) {}
}