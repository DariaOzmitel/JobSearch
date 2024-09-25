package com.example.ui.molecules.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.buttons.GreenButton
import com.example.ui.elements.text.Text1
import com.example.ui.elements.text.TextTitle3
import com.example.ui.mockVacancy
import com.example.ui.models.VacancyCardUI
import com.example.ui.theme.JobSearchTheme

@Composable
internal fun VacancyCard(
    modifier: Modifier = Modifier,
    vacancy: VacancyCardUI,
    isFavourite: Boolean = false,
    onImageClickListener: () -> Unit,
    onCardClickListener: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardClickListener() }
            .background(JobSearchTheme.colors.basicGrey1, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            modifier = Modifier
                .size(24.dp)
                .clickable { onImageClickListener() },
            painter = when (isFavourite) {
                true -> {
                    painterResource(id = R.drawable.heart)
                }

                false -> {
                    painterResource(id = R.drawable.favorites)
                }
            },
            contentDescription = ""
        )
        Column {
            vacancy.lookingNumber?.let {
                Text1(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = LocalContext.current.resources.getQuantityString(
                        R.plurals.current_looking_numbers,
                        vacancy.lookingNumber,
                        vacancy.lookingNumber
                    ),
                    color = JobSearchTheme.colors.specialGreen
                )
            }
            TextTitle3(
                modifier = Modifier.padding(bottom = 10.dp),
                text = vacancy.title,
                color = JobSearchTheme.colors.basicWhite
            )
            vacancy.town.let {
                Text1(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = it,
                    color = JobSearchTheme.colors.basicWhite
                )
            }
            Row(modifier = Modifier.padding(bottom = 10.dp)) {
                Text1(
                    modifier = Modifier.padding(end = 8.dp),
                    text = vacancy.company,
                    color = JobSearchTheme.colors.basicWhite
                )
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.verified_company),
                    contentDescription = ""
                )
            }
            vacancy.experienceText.let {
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    Image(
                        modifier = Modifier.padding(end = 8.dp),
                        painter = painterResource(id = R.drawable.portfolio),
                        contentDescription = ""
                    )
                    Text1(text = it, color = JobSearchTheme.colors.basicWhite)
                }
            }
            Text1(
                modifier = Modifier.padding(bottom = 20.dp),
                text = String.format(
                    stringResource(id = R.string.publishing_date),
                    vacancy.publishedDate
                ), color = JobSearchTheme.colors.basicGrey3
            )
            GreenButton(text = stringResource(id = R.string.respond))
        }
    }
}

@Preview
@Composable
private fun VacancyCardPreview() {
    VacancyCard(vacancy = mockVacancy, onImageClickListener = {}) {}
}