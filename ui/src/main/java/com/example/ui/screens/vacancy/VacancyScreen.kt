package com.example.ui.screens.vacancy

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.QuestionBoxColumn
import com.example.ui.elements.buttons.BigGreenButton
import com.example.ui.elements.text.Text1
import com.example.ui.elements.text.TextTitle1
import com.example.ui.elements.text.TextTitle2
import com.example.ui.elements.text.TextTitle4
import com.example.ui.mockVacancyForScreen
import com.example.ui.models.VacancyForScreenUi
import com.example.ui.molecules.cards.CompanyCard
import com.example.ui.molecules.cards.GreenCard
import com.example.ui.orZero
import com.example.ui.theme.JobSearchTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun VacancyScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    onArrowClickListener: () -> Unit
) {
    val viewModel: VacancyScreenViewModel = koinViewModel()
    val vacancyState by viewModel.getVacancyState().collectAsStateWithLifecycle()

    when (val state = vacancyState) {
        is VacancyState.Loading ->
            ProgressIndicator()

        is VacancyState.Vacancy -> {
            VacancyScreenContent(
                modifier = modifier,
                innerPadding = innerPadding,
                vacancy = state.vacancy,
                onArrowClickListener = onArrowClickListener,
                onImageClickListener = { viewModel.changeFavoriteStatus(it) }
            )
        }
    }
}

@Composable
fun VacancyScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    vacancy: VacancyForScreenUi,
    onImageClickListener: (String) -> Unit,
    onArrowClickListener: () -> Unit
) {
    LazyColumn(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = innerPadding.calculateTopPadding() + 8.dp,
            bottom = innerPadding.calculateBottomPadding()
        )
    ) {
        item {
            Row(
                modifier = Modifier.padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.weight(1f)) {
                    Image(
                        modifier = Modifier.clickable {
                            onArrowClickListener()
                        },
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = ""
                    )
                }
                Image(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.visible),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.clickable { onImageClickListener(vacancy.id) },
                    painter = when (vacancy.isFavorite) {
                        true -> {
                            painterResource(id = R.drawable.heart)
                        }

                        false -> {
                            painterResource(id = R.drawable.favorites)
                        }
                    },
                    contentDescription = ""
                )
            }
        }
        item {
            TextTitle1(
                modifier = Modifier.padding(bottom = 16.dp),
                text = vacancy.title,
                color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            Text1(
                modifier = Modifier.padding(bottom = 16.dp),
                text = vacancy.salary,
                color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            Text1(
                modifier = Modifier.padding(bottom = 6.dp), text = String.format(
                    stringResource(
                        id = R.string.required_experience
                    ), vacancy.experience
                ), color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            Text1(
                modifier = Modifier.padding(bottom = 16.dp),
                text = vacancy.schedules,
                color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            Row(
                modifier = Modifier.padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GreenCard(
                    modifier = Modifier.weight(1f),
                    text = LocalContext.current.resources.getQuantityString(
                        R.plurals.response_number,
                        vacancy.appliedNumber.orZero(),
                        vacancy.appliedNumber.orZero(),
                    ),
                    painter = painterResource(id = R.drawable.person)
                )

                GreenCard(
                    modifier = Modifier.weight(1f),
                    text = LocalContext.current.resources.getQuantityString(
                        R.plurals.looking_number,
                        vacancy.lookingNumber.orZero(),
                        vacancy.lookingNumber.orZero(),
                    ),
                    painter = painterResource(id = R.drawable.visible_green)
                )
            }
        }
        item {
            CompanyCard(
                modifier = Modifier.padding(bottom = 16.dp),
                company = vacancy.company,
                address = vacancy.address
            )
        }
        item {
            vacancy.description?.let {
                Text1(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = it,
                    color = JobSearchTheme.colors.basicWhite
                )
            }
        }
        item {
            TextTitle2(
                modifier = Modifier.padding(bottom = 8.dp),
                text = stringResource(id = R.string.your_tasks),
                color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            Text1(
                modifier = Modifier.padding(bottom = 32.dp),
                text = vacancy.responsibilities,
                color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            TextTitle4(
                modifier = Modifier.padding(bottom = 8.dp),
                text = stringResource(id = R.string.ask_the_employer_question),
                color = JobSearchTheme.colors.basicWhite
            )
        }
        item {
            TextTitle4(
                modifier = Modifier.padding(bottom = 16.dp),
                text = stringResource(id = R.string.employer_question_text),
                color = JobSearchTheme.colors.basicGrey3
            )
        }
        item {
            QuestionBoxColumn(
                modifier = Modifier.padding(bottom = 16.dp),
                questionList = vacancy.questions
            )
        }
        item {
            BigGreenButton(text = stringResource(id = R.string.respond))
        }
    }
}

@Preview
@Composable
private fun VacancyScreenPreview() {
    VacancyScreenContent(
        innerPadding = PaddingValues(0.dp),
        vacancy = mockVacancyForScreen,
        onImageClickListener = {}) {}
}