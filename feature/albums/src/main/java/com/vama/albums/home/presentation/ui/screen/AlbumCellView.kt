package com.vama.albums.home.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vama.albums.home.domain.model.AlbumModel
import com.vama.ui.NetworkImage

@Composable
fun AlbumCellView(album: AlbumModel, onClick: (album: AlbumModel) -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick(album) }
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val albumName = album.name
        NetworkImage(
            album.albumImageUrl,
            contentDescription = albumName,
            modifier = Modifier.size(100.dp), contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(albumName, maxLines = 1, overflow = TextOverflow.Ellipsis)
        Text(album.artist, maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color.Magenta)
    }
}

@Composable
@Preview
fun AlbumCellViewPreview() {
    AlbumCellView(AlbumModel("", "album1", "artist1", "", "music", "","")) {}
}