package com.example.ui.screens.uiKit

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
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.JobSearchTextField
import com.example.ui.elements.buttons.BlueButton1
import com.example.ui.elements.buttons.BlueButton2
import com.example.ui.elements.buttons.GreenButton
import com.example.ui.elements.buttons.JobSearchTextButton

@Composable
fun UiKitScreen() {
    var displayText by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding(),
                start = 15.dp,
                end = 15.dp
            ), verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BlueButton1(text = stringResource(id = R.string.resume))
            BlueButton1(text = stringResource(id = R.string.resume), enabled = false)
            BlueButton2(text = stringResource(id = R.string.resume))
            BlueButton2(text = stringResource(id = R.string.resume), enabled = false)
            GreenButton(text = stringResource(id = R.string.resume))
            GreenButton(text = stringResource(id = R.string.resume), enabled = false)
            JobSearchTextField(displayText = displayText) {
                displayText = it
            }
            JobSearchTextButton(text = stringResource(id = R.string.log_in_with_password))
        }
    }
}