package com.example.ui.screens.favorites

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.text.Text1
import com.example.ui.elements.text.TextTitle2
import com.example.ui.mockVacanciesList
import com.example.ui.models.VacancyCardUI
import com.example.ui.molecules.cards.VacancyCard
import com.example.ui.orZero
import com.example.ui.theme.JobSearchTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FavoriteScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    onButtonClickListener: () -> Unit,
    onCardClickListener: (String) -> Unit,
) {

    val viewModel: FavoriteScreenViewModel = koinViewModel()
    val favoriteState by viewModel.getFavoriteState().collectAsStateWithLifecycle()

    when (val state = favoriteState) {
        is FavoriteState.Loading ->
            ProgressIndicator()

        is FavoriteState.VacancyList -> {
            FavoriteScreenContent(
                modifier = modifier,
                innerPadding = innerPadding,
                vacancyList = state.vacancyList,
                onCardClickListener = onCardClickListener,
                onImageClickListener = { viewModel.changeFavoriteStatus(it) }
            ) {
                onButtonClickListener()
            }
        }
    }

}

@Composable
private fun FavoriteScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    vacancyList: List<VacancyCardUI>?,
    onCardClickListener: (String) -> Unit,
    onImageClickListener: (String) -> Unit,
    onButtonClickListener: () -> Unit,
) {
    val vacanciesCount = vacancyList?.size.orZero()
    LazyColumn(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = innerPadding.calculateTopPadding() + 8.dp,
            bottom = innerPadding.calculateBottomPadding()
        )
    ) {
        item {
            TextTitle2(
                modifier = Modifier.padding(bottom = 24.dp),
                text = stringResource(id = R.string.favorites),
                color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            Text1(
                modifier = Modifier.padding(bottom = 16.dp),
                text = LocalContext.current.resources.getQuantityString(
                    R.plurals.vacancies_count,
                    vacanciesCount,
                    vacanciesCount
                ),
                color = JobSearchTheme.colors.basicGrey3
            )
        }
        vacancyList?.let {
            items(it) { vacancy ->
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
}

@Preview
@Composable
private fun FavoriteScreenPreview() {
    FavoriteScreenContent(
        innerPadding = PaddingValues(0.dp),
        vacancyList = mockVacanciesList,
        onCardClickListener = {},
        onImageClickListener = {},
    ) {}
}