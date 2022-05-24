package ca.sudbury.hojat.photofinder.contract

import ca.sudbury.hojat.photofinder.IOTaskResult
import ca.sudbury.hojat.photofinder.data.datamodel.PhotoResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * The class that implements this interface represents the data store
 * of the application and decides whether to load the data from
 * a local Room DB or calling the retrofit function, or getting needed data
 * from any other data source (such as cache or another module and so on).
 *
 * @author Hojat Ghasemi
 */
interface IRepository {

    val remoteDataSource: IRemoteDataSource

    /**
     * Makes the popular photos API call via data source. In an offline-first architecture, it is at this function
     * call that the Repository class would check if the data for the given page number exists in a Room
     * table, if so return the data from the db, else perform a retrofit call to obtain and store the data
     * into the db before returning the same
     * @param pageNumber Page number of the data called in a paginated data source
     */
    @ExperimentalCoroutinesApi
    suspend fun getPhotosByPage(pageNumber: Int): Flow<IOTaskResult<PhotoResponse>>
}