package com.vama.albums.home.presentation.ui.error

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vama.albums.R

@Composable
fun AlbumsFeedErrorView(message: String, retryAction: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(message, textAlign = TextAlign.Center)
            Button(onClick = retryAction) {
                Text(stringResource(id = R.string.albums_feed_error_btn_retry))
            }
        }

    }
}

@Composable
@Preview
fun AlbumsFeedErrorViewPreview() {
    AlbumsFeedErrorView("Error") {}
}