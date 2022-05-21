package ca.sudbury.hojat.photofinder

import android.app.Application

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 */


/**
 * Configuration singleton object.
 */
object PhotoFinder {

    internal const val accessKey = "_htwco9giNp8TaA8kshIB3VP0eUZq5Y4pFWHLQuNPRU"
    internal const val secretKey = "2LCXsb9sP2coqIQ0McGNzgWJZsPVLL6Lcvr-HGO5Ydc"


    private const val DEFAULT_PAGE_SIZE = 20

    private var pageSize: Int = DEFAULT_PAGE_SIZE

    private var isLoggingEnabled = false

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
