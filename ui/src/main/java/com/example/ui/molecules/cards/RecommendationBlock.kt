package com.example.ui.molecules.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.elements.text.Text1
import com.example.ui.elements.text.TextTitle4
import com.example.ui.mockRecommendation
import com.example.ui.mockRecommendationList
import com.example.ui.models.OfferUI
import com.example.ui.theme.JobSearchTheme

private const val MAX_TITLE_LINES_WITH_BUTTON = 2
private const val MAX_TITLE_LINES_WITHOUT_BUTTON = 3
private const val MAX_BUTTON_TEXT_LINES = 1

@Composable
internal fun RecommendationBlock(
    modifier: Modifier = Modifier,
    recommendationList: List<OfferUI>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(recommendationList) {
            RecommendationCard(recommendation = it) {
            }
        }
    }
}

@Composable
private fun RecommendationCard(
    modifier: Modifier = Modifier,
    recommendation: OfferUI,
    onCardClickListener: () -> Unit
) {
    Box(
        modifier = modifier
            .width(132.dp)
            .height(120.dp)
            .background(JobSearchTheme.colors.basicGrey1, shape = RoundedCornerShape(8.dp))
            .clickable { onCardClickListener() }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)
        ) {
            when (recommendation.iconResId != null) {
                true -> Image(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(32.dp),
                    painter = painterResource(id = recommendation.iconResId),
                    contentDescription = ""
                )

                false -> Spacer(modifier = Modifier.height(48.dp))
            }
            TextTitle4(
                text = recommendation.title,
                color = JobSearchTheme.colors.basicWhite,
                maxLines = when (recommendation.buttonText.isNullOrEmpty()) {
                    true -> MAX_TITLE_LINES_WITHOUT_BUTTON
                    false -> MAX_TITLE_LINES_WITH_BUTTON
                }
            )
            recommendation.buttonText?.let {
                Text1(
                    text = it,
                    color = JobSearchTheme.colors.specialGreen,
                    maxLines = MAX_BUTTON_TEXT_LINES
                )
            }
        }
    }
}

@Preview
@Composable
private fun RecommendationCardPreview() {
    RecommendationCard(recommendation = mockRecommendation) {}
}

@Preview
@Composable
private fun RecommendationBlockPreview() {
    RecommendationBlock(recommendationList = mockRecommendationList)
}