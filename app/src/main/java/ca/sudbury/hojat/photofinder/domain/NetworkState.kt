package ca.sudbury.hojat.photofinder.domain

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * contact the author at "https://github.com/hojat72elect"
 *
 * usage of states to understand the network situation
 */
enum class Status {
    LOADING,
    SUCCESS,
    FAILURE
}

data class NetworkState private constructor(
    val status: Status,
    val msg: String? = null
) {
    companion object {
        val SUCCESS = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.LOADING)
        fun error(msg: String?) = NetworkState(Status.FAILURE, msg)
    }
}