package ca.sudbury.hojat.photofinder.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.sudbury.hojat.photofinder.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * This activity acts as the host for all fragments in the application
 * @author Hojat Ghasemi
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}