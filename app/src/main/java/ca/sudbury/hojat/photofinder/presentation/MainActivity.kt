package ca.sudbury.hojat.photofinder.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.R
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var unsplashViewModel: UnsplashViewModel
    private lateinit var adapter: PhotosRecyclerViewAdapter
    private val TAG = "Main_Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        ) // for easy connection of Activity with xml files.

        // Creating the view model
//        unsplashViewModel =
//            ViewModelProvider(this, UnsplashViewModelFactory(RemotePhotoDataSource())).get(
//                UnsplashViewModel::class.java
//            )



        // the binding between ViewModel and UI is controlled by the lifecycle of this Activity
        binding.myViewModel = unsplashViewModel
        binding.lifecycleOwner = this

        initRecyclerView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView() {

        binding.photosRecyclerView.layoutManager =
            LinearLayoutManager(this)// responsible for measuring, positioning and recycling item views.

        adapter = PhotosRecyclerViewAdapter { selectedItem: Photo -> listItemClicked(selectedItem) }
        binding.photosRecyclerView.adapter = adapter // loading the adapter for our recycler view

//        val photos = unsplashViewModel.getAllPhotos()
//        Log.d(TAG, photos.toString())
//        photos.observe(this) {
//            adapter.setList(it)
//            adapter.notifyDataSetChanged()
//        }
    }

    private fun listItemClicked(photo: Photo) {
        Toast.makeText(this, "photo selected", Toast.LENGTH_SHORT).show()

    }

}