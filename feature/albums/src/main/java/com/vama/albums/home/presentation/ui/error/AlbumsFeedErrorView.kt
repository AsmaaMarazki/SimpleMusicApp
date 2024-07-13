package com.vama.albums.home.presentation.ui.error

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vama.albums.R
import com.vama.ui.card.CardWithMessageAndAction

@Composable
fun AlbumsFeedErrorView(message: String, retryAction: () -> Unit) {
    CardWithMessageAndAction(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        message = message,
        actionText = stringResource(id = R.string.albums_feed_error_btn_retry),
        action = retryAction
    )
}

@Composable
@Preview
fun AlbumsFeedErrorViewPreview() {
    AlbumsFeedErrorView("Error") {}
}