package com.vama.albums.home.presentation.ui.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vama.ui.loading.FullScreenCircularLoading

@Composable
fun AlbumsFeedLoadingView() {
    FullScreenCircularLoading()
}

@Preview
@Composable
private fun AlbumsFeedLoadingViewPreview() {
    AlbumsFeedLoadingView()
}