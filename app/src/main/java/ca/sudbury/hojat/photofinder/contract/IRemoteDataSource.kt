package ca.sudbury.hojat.photofinder.contract

import ca.sudbury.hojat.photofinder.IOTaskResult
import ca.sudbury.hojat.photofinder.data.datamodel.PhotoResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Contract for the remote data source that will provide the plug to access network data by obtaining
 * an instance of [IWebService] interface in the implementing class
 * @author Prasan
 * @since 1.0
 * @see IWebService
 */
interface IRemoteDataSource {

    // Webservice Interface that a remote data source impl class needs to provide
    val webService: IWebService

    /**
     * Requests the webservice class to obtain a list of photos by page number
     * @param pageNumber Page Number
     * @return [Flow] of [IOTaskResult] of [PhotoResponse] type
     */
    @ExperimentalCoroutinesApi
    suspend fun getPhotosByPage(pageNumber: Int): Flow<IOTaskResult<PhotoResponse>>
}