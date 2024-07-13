package com.vama.albums.details.domain.usecase

import com.vama.albums.details.domain.model.AlbumDetailsModel
import com.vama.albums.details.domain.repository.AlbumDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetAlbumDetailsUseCase(
    private val albumDetailsRepository: AlbumDetailsRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(albumId: String): AlbumDetailsModel? {
        return withContext(dispatcher) {
            albumDetailsRepository.getAlbumDetails(albumId)
        }
    }
}
