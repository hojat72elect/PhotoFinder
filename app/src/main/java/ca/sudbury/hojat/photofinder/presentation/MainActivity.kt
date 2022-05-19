package ca.sudbury.hojat.photofinder.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

//    private lateinit var myViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button.text = "click me as hard as you can!"
        setContentView(binding.root)

    }


}