package com.example.ui.screens.vacancy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.QuestionBoxColumn
import com.example.ui.elements.buttons.GreenButton
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

private const val MAX_TEXT_LINES = 2

@Composable
fun VacancyScreen(modifier: Modifier = Modifier, innerPadding: PaddingValues) {
    VacancyScreenContent(
        modifier = modifier,
        innerPadding = innerPadding,
        vacancy = mockVacancyForScreen
    )
}

@Composable
fun VacancyScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    vacancy: VacancyForScreenUi
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
                Image(painter = painterResource(id = R.drawable.heart), contentDescription = "")
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
                    text = stringResource(id = R.string.response_number), painter = painterResource(
                        id = R.drawable.person
                    ), argForText = vacancy.appliedNumber.orZero()
                )

                GreenCard(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.looking_number), painter = painterResource(
                        id = R.drawable.visible_green
                    ), argForText = vacancy.lookingNumber.orZero()
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
            Text1(
                modifier = Modifier.padding(bottom = 16.dp),
                text = vacancy.description,
                color = JobSearchTheme.colors.basicWhite
            )
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
            GreenButton(text = stringResource(id = R.string.respond))
        }
    }
}

@Preview
@Composable
fun VacancyScreenPreview() {
    VacancyScreen(innerPadding = PaddingValues(0.dp))
}