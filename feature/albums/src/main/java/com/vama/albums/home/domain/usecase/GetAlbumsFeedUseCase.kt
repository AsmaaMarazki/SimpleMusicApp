package com.vama.albums.home.domain.usecase

import com.vama.albums.home.domain.model.AlbumsFeedModel
import com.vama.albums.home.domain.repository.AlbumsFeedRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetAlbumsFeedUseCase(
    private val albumsFeedRepository: AlbumsFeedRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): AlbumsFeedModel  {
        return withContext(dispatcher) {
            albumsFeedRepository.getAlbumsFeed()
        }
    }

}