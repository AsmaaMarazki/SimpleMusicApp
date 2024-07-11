package com.vama.albums.home.domain.usecase

import com.vama.albums.home.domain.model.AlbumModel
import com.vama.albums.home.domain.repository.AlbumsFeedRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetAlbumsFeedUseCase(
    private val albumsFeedRepository: AlbumsFeedRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): List<AlbumModel>  {
        return withContext(dispatcher) {
            albumsFeedRepository.getAlbumsFeed()
        }
    }

}