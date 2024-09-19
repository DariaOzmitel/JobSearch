package com.example.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.elements.text.Text1
import com.example.ui.theme.JobSearchTheme

@Composable
internal fun JobSearchTextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    displayText: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = JobSearchTheme.colors.basicGrey2, shape = RoundedCornerShape(8.dp))
            .padding(10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = displayText,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            textStyle = JobSearchTheme.typography.text1.copy(color = JobSearchTheme.colors.basicWhite),
            cursorBrush = SolidColor(JobSearchTheme.colors.basicWhite)
        ) { innerTextField ->
            if (displayText.isBlank()) {
                Text1(text = hint, color = JobSearchTheme.colors.basicWhite)
            }
            innerTextField()
        }
    }
}

@Preview
@Composable
private fun JobSearchTextFieldPreview() {
    JobSearchTextField(hint = "sdds", displayText = "") {
    }
}