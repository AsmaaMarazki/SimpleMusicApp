package com.vama.database.albums.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class AlbumEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var name: String = ""
    var artist: String = ""
    var albumImageUrl: String = ""
    var genre: String? = null
    var releaseDate: String? = null
    var copyright: String? = null
}