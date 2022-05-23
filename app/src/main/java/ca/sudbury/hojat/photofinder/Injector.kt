package ca.sudbury.hojat.photofinder

import ca.sudbury.hojat.photofinder.data.NetworkEndpoints
import ca.sudbury.hojat.photofinder.domain.PhotoRepository
import ca.sudbury.hojat.photofinder.presentation.PhotoViewModelFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Manual dependency injection to avoid sticking to a specific dependency injection library.
 *
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 */
object Injector {

    internal const val accessKey = "_htwco9giNp8TaA8kshIB3VP0eUZq5Y4pFWHLQuNPRU"
    internal const val secretKey = "2LCXsb9sP2coqIQ0McGNzgWJZsPVLL6Lcvr-HGO5Ydc"
    private const val CONTENT_TYPE = "Content-Type"
    private const val APPLICATION_JSON = "application/json"
    private const val ACCEPT_VERSION = "Accept-Version"
    private const val DEFAULT_PAGE_SIZE = 20
    private var pageSize: Int = DEFAULT_PAGE_SIZE
    private var isLoggingEnabled = false


    private fun createHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .addHeader(ACCEPT_VERSION, "v1")
                .build()
            chain.proceed(newRequest)
        }
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private fun createHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(createHeaderInterceptor())

        if (isLoggingEnabled()) {
            builder.addNetworkInterceptor(createLoggingInterceptor())
        }

        return builder.build()
    }

    private fun createRetrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NetworkEndpoints.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(createHttpClient())
            .build()
    }

    private fun createNetworkEndpoints(): NetworkEndpoints =
        createRetrofitBuilder().create(NetworkEndpoints::class.java)

    private fun createRepository(): PhotoRepository {
        return PhotoRepository(createNetworkEndpoints())
    }

    fun createPickerViewModelFactory(): PhotoViewModelFactory {
        return PhotoViewModelFactory(createRepository())
    }

    fun getPageSize(): Int {
        return pageSize
    }

    fun setLoggingEnabled(isEnabled: Boolean) {
        isLoggingEnabled = isEnabled
    }

    fun isLoggingEnabled(): Boolean {
        return isLoggingEnabled
    }
}
