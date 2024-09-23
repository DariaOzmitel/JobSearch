package com.example.ui.molecules.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.Text1
import com.example.ui.theme.JobSearchTheme

private const val MAX_TEXT_LINES = 2

@Composable
internal fun GreenCard(
    modifier: Modifier = Modifier,
    text: String,
    painter: Painter,
) {
    Box(
        modifier = modifier
            .background(JobSearchTheme.colors.specialDarkGreen, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Row {
            Text1(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .weight(1f),
                text = text,
                maxLines = MAX_TEXT_LINES,
                color = JobSearchTheme.colors.basicWhite
            )
            Image(painter = painter, contentDescription = "")
        }
    }
}

@Preview
@Composable
private fun GreenCardPreview() {
    GreenCard(
        text = stringResource(id = R.string.respond),
        painter = painterResource(id = R.drawable.person),
    )
}