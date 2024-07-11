package com.vama.albums.home.data.dto

import com.google.gson.annotations.SerializedName

data class AlbumsFeedResponse(@SerializedName("feed") val albumsFeed: AlbumsFeedResponse? = null)

