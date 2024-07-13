package com.vama.albums.details.presentation.model

sealed class AlbumDetailsEvent {
    class GetAlbumDetails(val albumId: String?) : AlbumDetailsEvent()
}