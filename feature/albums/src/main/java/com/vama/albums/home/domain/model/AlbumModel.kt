package com.vama.albums.home.domain.model


data class AlbumModel(
    val id: String,
    val name: String,
    val artist: String,
    val albumImageUrl: String,
    val genre: String?,
    val releaseDate: String?,
    val copyright: String?
)