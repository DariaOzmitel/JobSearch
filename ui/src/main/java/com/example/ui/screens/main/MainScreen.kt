package com.example.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.JobSearchTextField
import com.example.ui.elements.buttons.BlueButton1
import com.example.ui.elements.text.TextTitle2
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.mockRecommendationList
import com.example.ui.mockVacanciesList
import com.example.ui.molecules.cards.RecommendationBlock
import com.example.ui.molecules.cards.VacancyCard
import com.example.ui.theme.JobSearchTheme

private const val MAX_VACANCIES_CARD = 3

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    onButtonClickListener: () -> Unit
) {
    var displayText by rememberSaveable {
        mutableStateOf("")
    }
    val invisibleVacanciesCount = mockVacanciesList.size - MAX_VACANCIES_CARD
    LazyColumn(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = innerPadding.calculateTopPadding() + 8.dp,
            bottom = innerPadding.calculateBottomPadding()
        )
    ) {
        item {
            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                JobSearchTextField(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(1f),
                    hintText = stringResource(id = R.string.search_field_hint_main),
                    hintImage = painterResource(id = R.drawable.search),
                    displayText = displayText
                ) {
                    displayText = it
                }
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.filter_button),
                    contentDescription = ""
                )
            }
        }
        item {
            RecommendationBlock(
                modifier = Modifier
                    .ignoreHorizontalParentPadding()
                    .padding(bottom = 32.dp),
                recommendationList = mockRecommendationList
            )
        }
        item {
            TextTitle2(
                modifier = Modifier.padding(bottom = 16.dp),
                text = stringResource(id = R.string.vacancies_for_you),
                color = JobSearchTheme.colors.basicWhite
            )
        }
        items(mockVacanciesList.take(MAX_VACANCIES_CARD)) {
            VacancyCard(modifier = Modifier.padding(bottom = 16.dp), vacancy = it) {
            }
        }
        if (invisibleVacanciesCount > 0) {
            item {
                BlueButton1(
                    text = String.format(
                        stringResource(id = R.string.more_vacancy_count),
                        invisibleVacanciesCount
                    )
                ) {
                    onButtonClickListener()
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(innerPadding = PaddingValues(0.dp)) {}
}