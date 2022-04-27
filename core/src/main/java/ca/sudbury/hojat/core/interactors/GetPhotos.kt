package ca.sudbury.hojat.core.interactors

import ca.sudbury.hojat.core.data.PhotoRepository

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 */
class GetPhotos(private val photoRepository: PhotoRepository) {
    operator fun invoke() = photoRepository.getPhotos()
}