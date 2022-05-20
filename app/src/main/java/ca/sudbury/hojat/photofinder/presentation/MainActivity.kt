package ca.sudbury.hojat.photofinder.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.sudbury.hojat.photofinder.Injector
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: PhotoViewModel
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

        myViewModel.photosLiveData.observe(this, Observer {

            Log.d("Resulting_Photo", it[2]?.links?.html.toString())
        })

        myViewModel.registerPhotosLiveData()
    }


}