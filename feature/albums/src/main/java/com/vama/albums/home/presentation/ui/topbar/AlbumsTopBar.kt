package com.vama.albums.home.presentation.ui.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.vama.albums.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumsFeedTopBar() {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.albums_feed_topbar_title))
        })
}