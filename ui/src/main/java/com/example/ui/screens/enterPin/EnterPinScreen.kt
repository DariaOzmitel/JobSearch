package com.example.ui.screens.enterPin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.elements.CustomPin
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.buttons.BlueButton1
import com.example.ui.elements.text.TextTitle2
import com.example.ui.elements.text.TextTitle3
import com.example.ui.theme.JobSearchTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun EnterPinScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    onButtonClickListener: () -> Unit,
) {
    val viewModel: EnterPinScreenViewModel = koinViewModel()
    val enterPinState by viewModel.getEnterPinState().collectAsStateWithLifecycle()
    when (val state = enterPinState) {
        is EnterPinState.Loading ->
            ProgressIndicator()

        is EnterPinState.EnterPin -> {
            EnterPinScreenContent(
                modifier = modifier,
                innerPadding = innerPadding,
                pin = state.pin,
                mail = state.mail,
                onButtonClickListener = {
                    viewModel.addUser(state.mail)
                    onButtonClickListener()
                }
            ) {
                viewModel.updatePin(it)
            }
        }
    }
}

@Composable
private fun EnterPinScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    pin: String,
    mail: String,
    onButtonClickListener: () -> Unit,
    onValueChangeListener: (String) -> Unit
) {
    var isButtonEnabled by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding() + 192.dp,
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextTitle2(
            text = String.format(
                stringResource(id = R.string.send_code),
                mail
            ),
            color = JobSearchTheme.colors.basicWhite
        )
        TextTitle3(
            text = stringResource(id = R.string.send_code_text),
            color = JobSearchTheme.colors.basicWhite
        )
        CustomPin(displayText = pin, onValueChangeListener = { onValueChangeListener(it) }) {
            isButtonEnabled = true
        }
        BlueButton1(text = stringResource(id = R.string.confirm), enabled = isButtonEnabled) {
            onButtonClickListener()
        }
    }
}

@Preview
@Composable
private fun EnterPinScreenPreview() {
    EnterPinScreenContent(
        innerPadding = PaddingValues(0.dp),
        pin = "",
        mail = "fukgkk@mail.ru", onButtonClickListener = {}) {}
}