package com.vama.albums.home.domain.model

data class AlbumsFeedModel(val copyright: String, val albums: List<AlbumModel>)
data class AlbumModel(
    val id: String,
    val name: String,
    val artist: String,
    val albumImageUrl: String?,
    val genre: String,
    val releaseDate: String
)