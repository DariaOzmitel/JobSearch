package com.example.ui.molecules.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.JobSearchTextField
import com.example.ui.elements.buttons.BlueButton2
import com.example.ui.elements.buttons.JobSearchTextButton
import com.example.ui.elements.text.TextTitle3
import com.example.ui.theme.JobSearchTheme

@Composable
internal fun JobSearchCard(
    modifier: Modifier = Modifier,
    displayText: String,
    onButtonClickListener: () -> Unit,
    onValueChangeListener: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(JobSearchTheme.colors.basicGrey1)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextTitle3(
                text = stringResource(id = R.string.job_search),
                color = JobSearchTheme.colors.basicWhite
            )
            JobSearchTextField(
                displayText = displayText,
                hintText = stringResource(id = R.string.enter_mail)
            ) {
                onValueChangeListener(it)
            }
            Row {
                BlueButton2(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.resume),
                    onClick = onButtonClickListener
                )
                JobSearchTextButton(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.log_in_with_password)
                )
            }
        }
    }
}

@Preview
@Composable
private fun JobSearchCardPreview() {
    JobSearchCard(displayText = "", onButtonClickListener = {}) {}
}