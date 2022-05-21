package ca.sudbury.hojat.photofinder.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import ca.sudbury.hojat.photofinder.Injector
import ca.sudbury.hojat.photofinder.data.UnsplashPhoto
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: PhotoViewModel
    private lateinit var adapter: HojatPhotosRecyclerViewAdapter
    private val TAG = "Main_Activity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button.text = "click me as hard as you can!"
        setContentView(binding.root)

        myViewModel = ViewModelProvider(
            this,
            Injector.createPickerViewModelFactory()
        )[PhotoViewModel::class.java]

        initRecyclerView()

        myViewModel.registerPhotosLiveData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView() {
        // we use to log the page of data, but not anymore.
//        myViewModel.photosLiveData.observe(this) {
//            Log.d("Resulting_Photo", it.toString())
//        }

        binding.photosRecyclerView.layoutManager =
            LinearLayoutManager(this)// responsible for measuring, positioning and recycling item views.
        adapter = HojatPhotosRecyclerViewAdapter { selectedItem: UnsplashPhoto ->
            listItemClicked(selectedItem)
        }
        binding.photosRecyclerView.adapter = adapter // loading the adapter for our recycler view

        myViewModel.photosLiveData.observe(this) { pagedPhotos: PagedList<UnsplashPhoto> ->

            adapter.setList(pagedPhotos)
            adapter.notifyDataSetChanged()
            //todo: the RecyclerView.Adapter used in here needs to be changed
            // accordingly to become suitable for Paged data.

        }


    }

    private fun listItemClicked(photo: UnsplashPhoto) {
        // user has clicked om one of photos.
        Toast.makeText(this, "$photo selected", Toast.LENGTH_SHORT).show()

    }


}