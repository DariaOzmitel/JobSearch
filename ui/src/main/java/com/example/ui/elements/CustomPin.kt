package com.example.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.elements.text.TextTitle1
import com.example.ui.theme.JobSearchTheme

const val PIN_LENGTH = 4

@Composable
fun CustomPin(
    modifier: Modifier = Modifier,
    displayText: String,
    onValueChangeListener: (String) -> Unit,
    correctPinEnteredListener: () -> Unit = {}
) {
    val interactionSource: MutableInteractionSource =
        remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(modifier = modifier, value = displayText, onValueChange = {
        if (it.length == PIN_LENGTH) {
            keyboardController?.hide()
        }
        onValueChangeListener(it)
    },
        interactionSource = interactionSource,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            PinString(inputText = displayText, isFocused = isFocused, correctPinEnteredListener)
        }
    )
}

@Composable
fun PinString(inputText: String, isFocused: Boolean, correctPinEnteredListener: () -> Unit = {}) {
    val inputTextLength = inputText.length
    val correctPinEntered = inputTextLength == PIN_LENGTH
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(PIN_LENGTH) { index ->
            Box(
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(JobSearchTheme.colors.basicGrey2)
                )
                when {
                    index < inputTextLength -> {
                        TextTitle1(
                            text = inputText[index].toString(),
                            color = JobSearchTheme.colors.basicGrey3
                        )
                    }

                    isFocused && (index == inputTextLength) -> {
                        TextTitle1(
                            text = "|",
                            color = JobSearchTheme.colors.basicGrey3
                        )
                    }

                    else -> {
                        TextTitle1(
                            modifier = Modifier.padding(top = 8.dp),
                            text = "*",
                            color = JobSearchTheme.colors.basicGrey3
                        )
                    }
                }
                if (correctPinEntered) {
                    correctPinEnteredListener()
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomPinPreview() {
    CustomPin(displayText = "", onValueChangeListener = {})
}