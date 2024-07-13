package com.vama.ui.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardWithMessageAndAction(
    modifier: Modifier,
    message: String,
    actionText: String,
    action: () -> Unit
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(message, textAlign = TextAlign.Center)
            Button(onClick = action) {
                Text(actionText)
            }
        }

    }
}

@Preview
@Composable
fun CardWithMessageAndActionPreview() {
    CardWithMessageAndAction(
        modifier = Modifier,
        message = "Error",
        actionText = "Retry",
        action = {})

}