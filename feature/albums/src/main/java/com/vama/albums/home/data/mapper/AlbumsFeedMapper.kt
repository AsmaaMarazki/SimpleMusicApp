package com.vama.albums.home.data.mapper

import com.vama.albums.home.data.dto.AlbumsFeedResponse
import com.vama.albums.home.domain.model.AlbumModel
import com.vama.albums.home.domain.model.AlbumsFeedModel
import javax.inject.Inject

class AlbumsFeedMapper @Inject constructor(){
    fun mapFrom(albumsFeedResponse: AlbumsFeedResponse): AlbumsFeedModel {
        val albumsFeedDto = albumsFeedResponse.albumsFeedDto
        return AlbumsFeedModel(
            copyright = albumsFeedDto?.copyright ?: "",
            albums = albumsFeedDto?.albums?.map {
                AlbumModel(
                    id = it.id ?: "",
                    name = it.name ?: "",
                    artist = it.artistName ?: "",
                    albumImageUrl = it.albumImageUrl ?: "",
                    genre = it.genres?.firstOrNull()?.name ?: "",
                    releaseDate = it.releaseDate ?: ""
                )
            } ?: listOf()
        )
    }

}