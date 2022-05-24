package ca.sudbury.hojat.photofinder.domain

import ca.sudbury.hojat.photofinder.IOTaskResult
import ca.sudbury.hojat.photofinder.contract.IRepository
import ca.sudbury.hojat.photofinder.data.datamodel.PhotoResponse
import ca.sudbury.hojat.photofinder.contract.IUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [IUseCase] class implementation that retrieves a paginated list of photos from the service
 * Takes a page number as input and returns the [IOTaskResult] [PhotoResponse] instance in return
 * @author Prasan
 * @since 1.0
 */
@Singleton
class GetPopularPhotosUseCase @Inject constructor(override val repository: IRepository) :
    IUseCase<Int, PhotoResponse> {

    @ExperimentalCoroutinesApi
    override suspend fun execute(input: Int): Flow<IOTaskResult<PhotoResponse>> =
        repository.getPhotosByPage(input)
}