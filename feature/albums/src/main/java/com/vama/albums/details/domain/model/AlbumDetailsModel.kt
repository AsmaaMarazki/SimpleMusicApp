package com.vama.albums.details.domain.model

data class AlbumDetailsModel(
    val name: String,
    val artist: String,
    val albumImageUrl: String,
    val genre: String?,
    val releaseDate: String?,
    val copyright: String?
)