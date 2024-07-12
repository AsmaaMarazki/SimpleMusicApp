package com.vama.albums.home.data.dto

import com.google.gson.annotations.SerializedName

data class AlbumDto(
    @SerializedName("artistName") var artistName: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("releaseDate") var releaseDate: String? = null,
    @SerializedName("kind") var kind: String? = null,
    @SerializedName("artistId") var artistId: String? = null,
    @SerializedName("artistUrl") var artistUrl: String? = null,
    @SerializedName("contentAdvisoryRating") var contentAdvisoryRating: String? = null,
    @SerializedName("artworkUrl100") var albumImageUrl: String? = null,
    @SerializedName("genres") var genres: List<GenreDto>? = null,
    @SerializedName("url") var url: String? = null
)