package com.example.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.elements.text.TextTitle4
import com.example.ui.mockVacancyForScreen
import com.example.ui.theme.JobSearchTheme

@Composable
private fun QuestionBox(
    modifier: Modifier = Modifier,
    question: String
) {
    Box(
        modifier = modifier
            .background(JobSearchTheme.colors.basicGrey2, shape = RoundedCornerShape(50.dp))
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        TextTitle4(text = question, color = JobSearchTheme.colors.basicWhite)
    }
}

@Composable
internal fun QuestionBoxColumn(
    modifier: Modifier = Modifier,
    questionList: List<String>?
) {
    questionList?.let { list ->
        Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            list.forEach {
                QuestionBox(question = it)
            }
        }
    }

}

@Preview
@Composable
private fun QuestionBoxPreview() {
    QuestionBox(question = "Где распологается место работы?")
}

@Preview
@Composable
private fun QuestionBoxColumnPreview() {
    QuestionBoxColumn(questionList = mockVacancyForScreen.questions)
}