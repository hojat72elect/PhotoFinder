package ca.sudbury.hojat.photofinder.data.network

import ca.sudbury.hojat.photofinder.IOTaskResult
import ca.sudbury.hojat.photofinder.contract.IWebService
import ca.sudbury.hojat.photofinder.data.datamodel.PhotoResponse
import ca.sudbury.hojat.photofinder.performSafeNetworkApiCall
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [IWebService] impl class which uses Retrofit to provide the app with the functionality to make
 * network requests
 * @author Prasan
 */
@Singleton
class RetrofitWebService @Inject constructor(private val retrofitClient: FiveHundredPixelsAPI) :
    IWebService {

    @ExperimentalCoroutinesApi
    override suspend fun getPhotosByPage(
        pageNumber: Int
    ): Flow<IOTaskResult<PhotoResponse>> =

        performSafeNetworkApiCall("Error Obtaining Photos") {
            retrofitClient.getPopularPhotos(
                page = pageNumber
            )
        }
}