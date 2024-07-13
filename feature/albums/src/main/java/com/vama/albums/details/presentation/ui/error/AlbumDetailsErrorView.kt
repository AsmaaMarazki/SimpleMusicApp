package com.vama.albums.details.presentation.ui.error

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vama.albums.R
import com.vama.ui.card.CardWithMessageAndAction

@Composable
fun AlbumDetailsErrorView(message: String, closeAction: () -> Unit) {
    CardWithMessageAndAction(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        message = message,
        actionText = stringResource(id = R.string.album_details_error_btn_close),
        action = closeAction
    )


}