package ca.sudbury.hojat.photofinder.di

import ca.sudbury.hojat.photofinder.BuildConfig
import ca.sudbury.hojat.photofinder.contract.IRemoteDataSource
import ca.sudbury.hojat.photofinder.contract.IRepository
import ca.sudbury.hojat.photofinder.contract.IWebService
import ca.sudbury.hojat.photofinder.data.FHPRepository
import ca.sudbury.hojat.photofinder.data.NetworkDataSource
import ca.sudbury.hojat.photofinder.data.network.FiveHundredPixelsAPI
import ca.sudbury.hojat.photofinder.data.network.RetrofitWebService
import ca.sudbury.hojat.photofinder.domain.GetPopularPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Hilt Module class that builds our dependency graph
 * @author Prasan
 * @since 1.0
 */
@InstallIn(ActivityComponent::class)
@Module
object HiltDependenciesModule {

    /**
     * Returns the [HttpLoggingInterceptor] instance with logging level set to body
     * @since 1.0.0
     */
    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    /**
     * Provides an [OkHttpClient]
     * @param loggingInterceptor [HttpLoggingInterceptor] instance
     * @since 1.0.0
     */
    @Provides
    fun provideOKHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient().apply {
        OkHttpClient.Builder().run {
            addInterceptor(loggingInterceptor)
            build()
        }
    }

    /**
     * Returns a [MoshiConverterFactory] instance
     * @since 1.0.0
     */
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    /**
     * Returns an instance of the [FiveHundredPixelsAPI] interface for the retrofit class
     * @return [FiveHundredPixelsAPI] impl
     * @since 1.0.0
     */
    @Provides
    fun provideRetrofitInstance(
        client: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): FiveHundredPixelsAPI =
        Retrofit.Builder().run {
            baseUrl(BuildConfig.BASE_URL)
            addConverterFactory(moshiConverterFactory)
            client(client)
            build()
        }.run {
            create(FiveHundredPixelsAPI::class.java)
        }


    /**
     * Returns a [IWebService] impl
     * @param retrofitClient [FiveHundredPixelsAPI] retrofit interface
     * @since 1.0.0
     */
    @Provides
    fun providesRetrofitService(retrofitClient: FiveHundredPixelsAPI): IWebService =
        RetrofitWebService(retrofitClient)

    /**
     * Returns a [IRemoteDataSource] impl
     * @param webService [IWebService] instance
     * @since 1.0.0
     */
    @Provides
    fun providesNetworkDataSource(webService: IWebService): IRemoteDataSource =
        NetworkDataSource(webService)

    /**
     * Returns a singleton [IRepository] implementation
     * @param remoteDataSource [IRemoteDataSource] implementation
     * @since 1.0.0
     */
    @Provides
    fun provideRepository(remoteDataSource: IRemoteDataSource): IRepository =
        FHPRepository(remoteDataSource)

    /**
     * Returns a [GetPopularPhotosUseCase] instance
     * @param repository [IRepository] impl
     * @since 1.0.0
     */
    @Provides
    fun provideUseCase(repository: IRepository): GetPopularPhotosUseCase =
        GetPopularPhotosUseCase(
            repository
        )
}