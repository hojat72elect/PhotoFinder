package ca.sudbury.hojat.photofinder.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.R
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding

const val EXTRA_PHOTO_ID = "ca.sudbury.hojat.photofinder.presentation.photoId"

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


        unsplashViewModel =
            ViewModelProvider(this, UnsplashViewModelFactory)[UnsplashViewModel::class.java]


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

        // first load photos out of Room DB
        unsplashViewModel.getAllRoomPhotos().observe(this, { roomPhotos ->
            if (roomPhotos.isEmpty()) {
                // Room DB is empty
                // fetch photos from web server
                unsplashViewModel.getAllRemotePhotos().observe(this, { remotePhotos: List<Photo>
                    ->
                    adapter.setList(remotePhotos)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "Data loaded from server", Toast.LENGTH_LONG).show()
                    // save the data you have downloaded from web server, into Room DB
                    remotePhotos.forEach {
                        unsplashViewModel.addRoomPhoto(it)
                    }

                })


            } else {
                // load the recycler view with data from Room DB
                adapter.setList(roomPhotos)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Data loaded from Room database", Toast.LENGTH_LONG).show()
            }
        })


    }

    private fun listItemClicked(photo: Photo) {

        val intent = Intent(this, PhotoDetailsActivity::class.java).apply {
            putExtra(EXTRA_PHOTO_ID, photo.id)
        }
        startActivity(intent)
    }

}