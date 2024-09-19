package com.example.ui.elements.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.ButtonText2
import com.example.ui.theme.JobSearchTheme

@Composable
internal fun JobSearchTextButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick, modifier = modifier
            .fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Unspecified,
            contentColor = JobSearchTheme.colors.specialBlue,
        ),
        contentPadding = PaddingValues(vertical = 11.dp)
    ) {
        ButtonText2(text = text)
    }
}

@Preview
@Composable
private fun JobSearchTextButtonPreview() {
    JobSearchTextButton(text = stringResource(id = R.string.log_in_with_password))
}