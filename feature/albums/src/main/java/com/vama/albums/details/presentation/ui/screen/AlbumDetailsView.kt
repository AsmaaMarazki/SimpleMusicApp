package com.vama.albums.details.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vama.albums.details.domain.model.AlbumDetailsModel
import com.vama.ui.image.NetworkImage

@Composable
fun AlbumDetailsView(albumDetailsModel: AlbumDetailsModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        val albumName = albumDetailsModel.name
        NetworkImage(
            albumDetailsModel.albumImageUrl,
            contentDescription = albumName,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(albumName)
            Text(albumDetailsModel.artist, color = Color.Magenta)
            albumDetailsModel.genre?.let {
                Text(it, color = Color.Red)
            }
            albumDetailsModel.releaseDate?.let {
                Text(it, color = Color.Blue)
            }
            albumDetailsModel.copyright?.let {
                Text(it, color = Color.Green)
            }
        }

    }
}

@Preview
@Composable
fun AlbumDetailsViewPreview() {
    AlbumDetailsView(
        AlbumDetailsModel(
            "1",
            "album1",
            "artist1", "Music", "11-11-2011", "Apple"
        )
    )
}