package com.example.ui.molecules.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.buttons.GreenButton
import com.example.ui.elements.text.ButtonText2
import com.example.ui.elements.text.TextTitle3
import com.example.ui.theme.JobSearchTheme

@Composable
internal fun EmployeeSearchCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(JobSearchTheme.colors.basicGrey1)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            TextTitle3(
                modifier = Modifier.padding(bottom = 8.dp),
                text = stringResource(id = R.string.search_employees),
                color = JobSearchTheme.colors.basicWhite
            )
            ButtonText2(
                modifier = Modifier.padding(bottom = 16.dp),
                text = stringResource(id = R.string.search_employees_text),
                color = JobSearchTheme.colors.basicWhite
            )
            GreenButton(
                text = stringResource(id = R.string.looking_for_employees)
            )
        }
    }
}

@Preview
@Composable
private fun EmployeeSearchCardPreview() {
    EmployeeSearchCard()
}