package com.vama.albums.home.data.source.remote

import com.vama.albums.home.data.dto.AlbumsFeedResponse
import retrofit2.http.GET

interface AlbumsServiceApi {
    @GET("api/v2/us/music/most-played/100/albums.json")
    suspend fun getAlbumsFeed(): AlbumsFeedResponse
}