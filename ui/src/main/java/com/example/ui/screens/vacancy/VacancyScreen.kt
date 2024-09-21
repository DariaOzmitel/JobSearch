package com.example.ui.screens.vacancy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.TextTitle1

@Composable
fun VacancyScreen(modifier: Modifier = Modifier, innerPadding: PaddingValues) {
    LazyColumn(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = innerPadding.calculateTopPadding() + 8.dp,
            bottom = innerPadding.calculateBottomPadding()
        )
    ) {
        item {
            Row(modifier = Modifier.padding(bottom = 24.dp)) {
                Image(
                    modifier = Modifier.weight(1f),
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.visible),
                    contentDescription = ""
                )
                Image(painter = painterResource(id = R.drawable.heart), contentDescription = "")
            }
        }
        item {
            TextTitle1(text = "")
        }
    }
}