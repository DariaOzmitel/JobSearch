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
import androidx.compose.ui.unit.dp
import com.example.ui.molecules.cards.EmployeeSearchCard
import com.example.ui.molecules.cards.JobSearchCard
import com.example.ui.theme.JobSearchTheme

@Composable
fun UiKitMoleculesScreen() {
    var displayText by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold(containerColor = JobSearchTheme.colors.basicBlack) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            ), verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            JobSearchCard(displayText = displayText) {
                displayText = it
            }
            EmployeeSearchCard()
        }
    }
}