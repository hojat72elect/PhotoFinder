package ca.sudbury.hojat.photofinder.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ca.sudbury.hojat.photofinder.R
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        ) // for easy connection of Activity with xml files.


    }


}