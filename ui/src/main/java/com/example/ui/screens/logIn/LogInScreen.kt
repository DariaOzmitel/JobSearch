package com.example.ui.screens.logIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.TextTitle2
import com.example.ui.molecules.cards.EmployeeSearchCard
import com.example.ui.molecules.cards.JobSearchCard
import com.example.ui.theme.JobSearchTheme

@Composable
fun LogInScreen(modifier: Modifier = Modifier) {
    var displayText by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold(containerColor = JobSearchTheme.colors.basicBlack) { innerPadding ->
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
                    displayText = displayText
                ) {
                    displayText = it
                }
                EmployeeSearchCard()
            }
        }
    }
}

@Preview
@Composable
fun LogInScreenPreview() {
    LogInScreen()
}