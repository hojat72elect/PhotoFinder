package ca.sudbury.hojat.photofinder.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.R
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding
import ca.sudbury.hojat.photofinder.framework.NetworkModel
import ca.sudbury.hojat.photofinder.framework.PhotoDataSourceImpl


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retService: NetworkModel
    private lateinit var unsplashViewModel: UnsplashViewModel
    private lateinit var adapter: PhotosRecyclerViewAdapter
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

//        binding.textViewLog.text = "I have added the data binding to this project!"

        initRecyclerView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView() {

        binding.photosRecyclerView.layoutManager =
            LinearLayoutManager(this)// responsible for measuring, positioning and recycling item views.

        adapter = PhotosRecyclerViewAdapter { selectedItem: Photo ->
            listItemClicked(selectedItem)
        }
        binding.photosRecyclerView.adapter = adapter // loading the adapter for our recycler view

        val photos = unsplashViewModel.getAllPhotos()
        Log.d("TAG_photos_list", photos.toString())
        adapter.setList(photos)
        adapter.notifyDataSetChanged()

    }

    private fun listItemClicked(photo: Photo) {
        Toast.makeText(this, "photo selected", Toast.LENGTH_SHORT).show()

    }

}