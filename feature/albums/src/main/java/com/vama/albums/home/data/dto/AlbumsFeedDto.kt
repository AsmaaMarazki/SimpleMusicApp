package com.vama.albums.home.data.dto

import com.google.gson.annotations.SerializedName

data class AlbumsFeedDto(
    val title: String? = null,
    val id: String? = null,
    val author: AlbumAuthorDto? = null,
    val copyright: String? = null,
    val country: String? = null,
    val icon: String? = null,
    @SerializedName("results") var albums: List<AlbumDto>? = null
)