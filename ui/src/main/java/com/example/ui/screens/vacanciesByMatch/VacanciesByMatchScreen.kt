package com.example.ui.screens.vacanciesByMatch

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.elements.JobSearchTextField
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.text.Text1
import com.example.ui.mockVacanciesList
import com.example.ui.models.VacancyCardUI
import com.example.ui.molecules.cards.VacancyCard
import com.example.ui.theme.JobSearchTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun VacanciesByMatchScreen(
    modifier: Modifier = Modifier, innerPadding: PaddingValues,
    onCardClickListener: (String) -> Unit,
) {
    val viewModel: VacanciesByMatchScreenViewModel = koinViewModel()
    val vacancyByMatchState by viewModel.getVacancyByMatchState().collectAsStateWithLifecycle()

    when (val state = vacancyByMatchState) {
        is VacanciesByMatchState.Loading ->
            ProgressIndicator()

        is VacanciesByMatchState.VacancyList -> {
            VacanciesByMatchScreenContent(
                modifier = modifier,
                innerPadding = innerPadding,
                vacancyList = state.vacancyList,
                onCardClickListener = onCardClickListener,
                onImageClickListener = { viewModel.changeFavoriteStatus(it) }
            )
        }
    }
}

@Composable
private fun VacanciesByMatchScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    vacancyList: List<VacancyCardUI>,
    onImageClickListener: (String) -> Unit,
    onCardClickListener: (String) -> Unit,
) {
    var displayText by rememberSaveable {
        mutableStateOf("")
    }
    val vacanciesCount = vacancyList.size
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
                    hintText = stringResource(id = R.string.search_field_hint),
                    hintImage = painterResource(id = R.drawable.arrow),
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
            Row(modifier = Modifier.padding(bottom = 24.dp)) {
                Text1(
                    modifier = Modifier.weight(1f),
                    text = LocalContext.current.resources.getQuantityString(
                        R.plurals.vacancies_count,
                        vacanciesCount,
                        vacanciesCount
                    ),
                    color = JobSearchTheme.colors.basicWhite
                )
                Text1(
                    modifier = Modifier.padding(end = 6.dp),
                    text = stringResource(id = R.string.by_match),
                    color = JobSearchTheme.colors.specialBlue
                )
                Image(painter = painterResource(id = R.drawable.filter), contentDescription = "")
            }
        }
        items(vacancyList) { vacancy ->
            VacancyCard(
                modifier = Modifier.padding(bottom = 16.dp),
                vacancy = vacancy,
                isFavourite = vacancy.isFavorite,
                onImageClickListener = { onImageClickListener(vacancy.id) }
            ) {
                onCardClickListener(vacancy.id)
            }
        }
    }
}

@Preview
@Composable
private fun VacanciesByMatchScreenPreview() {
    VacanciesByMatchScreenContent(
        innerPadding = PaddingValues(0.dp),
        vacancyList = mockVacanciesList,
        onImageClickListener = {}
    ) {}
}