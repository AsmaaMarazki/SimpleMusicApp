package com.vama.albums.details.data.mapper

import com.vama.albums.details.domain.model.AlbumDetailsModel
import com.vama.database.albums.entity.AlbumEntity
import javax.inject.Inject

class AlbumDetailsMapper @Inject constructor() {
    fun mapFrom(albumEntity: AlbumEntity): AlbumDetailsModel {
        return AlbumDetailsModel(
           name =  albumEntity.name,
           albumImageUrl =  albumEntity.albumImageUrl,
            artist = albumEntity.artist,
            genre = albumEntity.genre,
            releaseDate = albumEntity.releaseDate,
            copyright = albumEntity.copyright
        )
    }
}