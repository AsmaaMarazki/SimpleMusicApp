package com.vama.albums.home.data.mapper

import com.vama.albums.home.data.dto.AlbumDto
import com.vama.albums.home.data.dto.AlbumsFeedDto
import com.vama.albums.home.domain.model.AlbumModel
import com.vama.database.albums.entity.AlbumEntity
import javax.inject.Inject

class AlbumsFeedMapper @Inject constructor() {
    fun mapFrom(albumsFeedDto: AlbumsFeedDto?): List<AlbumModel>? {
        return albumsFeedDto?.albums?.mapNotNull {
            val albumId = it.id
            val albumName = it.name
            val artistName = it.artistName
            val albumImgUrl = it.albumImageUrl

            if (albumId.isNullOrEmpty() || albumName.isNullOrEmpty() || artistName.isNullOrEmpty() || albumImgUrl.isNullOrEmpty()) return@mapNotNull null

            AlbumModel(
                id = albumId,
                name = albumName,
                artist = artistName,
                albumImageUrl = albumImgUrl,
                genre = it.genres?.firstOrNull()?.name,
                releaseDate = it.releaseDate,
                copyright = albumsFeedDto.copyright
            )
        }

    }

    fun mapFrom(albumEntities: List<AlbumEntity>): List<AlbumModel> {
        return albumEntities.map {
            AlbumModel(
                it.id,
                it.name,
                it.artist,
                it.albumImageUrl,
                it.genre,
                it.releaseDate,
                it.copyright
            )
        }
    }

    fun mapFrom(albums: List<AlbumDto>, copyrightResponse: String?): List<AlbumEntity> {
        return albums.mapNotNull {
            val albumId = it.id
            val albumName = it.name
            val artistName = it.artistName
            val albumImgUrl = it.albumImageUrl

            if (albumId.isNullOrEmpty() || albumName.isNullOrEmpty() || artistName.isNullOrEmpty() || albumImgUrl.isNullOrEmpty()) return@mapNotNull null

            AlbumEntity().apply {
                id = albumId
                name = albumName
                artist = artistName
                albumImageUrl = albumImgUrl
                genre = it.genres?.firstOrNull()?.name
                releaseDate = it.releaseDate
                copyright = copyrightResponse
            }
        }
    }

}