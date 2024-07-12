package com.vama.albums.home.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vama.albums.home.domain.model.AlbumModel

@Composable
fun AlbumsFeedGridView(albums: List<AlbumModel>, onCellClick: (album: AlbumModel) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()

    ) {
        items(albums.size) { index ->
            AlbumCellView(album = albums[index], onClick = onCellClick)

        }
    }
}

@Composable
@Preview
fun AlbumsFeedGridViewPreview() {
    AlbumsFeedGridView(
        albums = listOf(
            AlbumModel("", "album1", "artist1", "", "music", ""),
            AlbumModel("", "album2", "artist2", "", "music", "")
        )
    ) {

    }
}