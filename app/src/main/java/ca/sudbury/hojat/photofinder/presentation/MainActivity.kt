package ca.sudbury.hojat.photofinder.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ca.sudbury.hojat.photofinder.R
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding
import ca.sudbury.hojat.photofinder.framework.NetworkModel
import ca.sudbury.hojat.photofinder.framework.PhotoDataSourceImpl


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retService: NetworkModel
    private lateinit var unsplashViewModel: UnsplashViewModel
    private val TAG = "Main_Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        ) // for easy connection of Activity with xml files.

        // The builder for ViewModel
        val factory = UnsplashViewModelFactory(PhotoDataSourceImpl(this))
        unsplashViewModel = ViewModelProvider(this, factory).get(
            UnsplashViewModel::class.java
        )

        binding.myViewModel = unsplashViewModel
        // but this binding exists just as long as this Activity lives
        // (this is a good way of getting rid of memory leaks).
        binding.lifecycleOwner = this

        binding.textViewLog.text = "I have added the data binding to this project!"

//        retService = PhotoDataSourceImpl
//            .getRetrofitInstance()
//            .create(NetworkModel::class.java)
//
//        getPhotos()

    }

//    private fun getPhotos() {
//        val responseLiveData: LiveData<Response<UnsplashJSON>> = liveData {
//
//            val response = retService.getPhotos()
//            emit(response)
//        }
//        responseLiveData.observe(this) {
//            val JSONBody = it.body()?.listIterator()
//            if (JSONBody != null) {
//                while (JSONBody.hasNext()) {
//                    Log.i(TAG, JSONBody.next().urls?.regular.toString())
//                }
//            }
//        }
//    }
}