package ca.sudbury.hojat.photofinder.data

import ca.sudbury.hojat.photofinder.IOTaskResult
import ca.sudbury.hojat.photofinder.data.datamodel.PhotoResponse
import ca.sudbury.hojat.photofinder.contract.IRemoteDataSource
import ca.sudbury.hojat.photofinder.contract.IRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository class impl from [IRepository]
 * @author Prasan
 * @since 1.0
 * @see IRepository
 * @see IRemoteDataSource
 */
@Singleton
class FHPRepository @Inject constructor(override val remoteDataSource: IRemoteDataSource) :
    IRepository {

    @ExperimentalCoroutinesApi
    override suspend fun getPhotosByPage(pageNumber: Int): Flow<IOTaskResult<PhotoResponse>> =
        remoteDataSource.getPhotosByPage(pageNumber)
}