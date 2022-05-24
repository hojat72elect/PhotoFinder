package ca.sudbury.hojat.photofinder.data

import ca.sudbury.hojat.photofinder.IOTaskResult
import ca.sudbury.hojat.photofinder.data.datamodel.PhotoResponse
import ca.sudbury.hojat.photofinder.contract.IRemoteDataSource
import ca.sudbury.hojat.photofinder.contract.IWebService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [IRemoteDataSource] impl class that provides access to network API calls
 * @author Prasan
 * @since 1.0
 * @see IRemoteDataSource
 * @see IWebService
 */
@Singleton
class NetworkDataSource @Inject constructor(override val webService: IWebService) :
    IRemoteDataSource {

    @ExperimentalCoroutinesApi
    override suspend fun getPhotosByPage(pageNumber: Int): Flow<IOTaskResult<PhotoResponse>> =
        webService.getPhotosByPage(pageNumber)
}