//package ca.sudbury.hojat.photofinder.presentation
//
//import android.net.Uri
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.ViewModelProvider
//import ca.sudbury.hojat.photofinder.R
//import ca.sudbury.hojat.photofinder.databinding.ActivityPhotoDetailsBinding
//import com.bumptech.glide.Glide
//
//class PhotoDetailsActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityPhotoDetailsBinding
//    private lateinit var unsplashViewModel: UnsplashViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(
//            this,
//            R.layout.activity_photo_details
//        )
//
//        // the ViewModel
//        unsplashViewModel =
//            ViewModelProvider(this, UnsplashViewModelFactory)[UnsplashViewModel::class.java]
//
//        // the binding between ViewModel and UI is controlled by the lifecycle of this Activity
//        binding.myViewModel = unsplashViewModel
//        binding.lifecycleOwner = this
//
//        // Get the chosen photo (out of Room)
//        val chosenPhotoId = intent.getStringExtra(EXTRA_PHOTO_ID) ?: ""
//        unsplashViewModel.getRoomPhoto(chosenPhotoId).observe(this) {
//            Glide.with(this)
//                .load(Uri.parse(it.url_full))
//                .into(binding.ivChosen)
//        }
//
//
//    }
//}