package ca.sudbury.hojat.photofinder.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ca.sudbury.hojat.photofinder.ViewState
import ca.sudbury.hojat.photofinder.databinding.FragmentPhotoDetailsBinding
import ca.sudbury.hojat.photofinder.presentation.MainViewModel
import ca.sudbury.hojat.photofinder.showToast


/**
 * [Fragment] displays details of the photo tapped on in [PopularPhotosFragment]
 * @author Hojat Ghasemi
 */
class PhotoDetailsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentPhotoDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoDetailsBinding.inflate(inflater)
        retainInstance = true
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.let {
            viewModel.processPhotoDetailsArgument(it)
                .observe(viewLifecycleOwner) { uiState ->
                    when (uiState) {
                        is ViewState.RenderSuccess ->
                            binding.photoDetails = uiState.output
                        is ViewState.RenderFailure ->
                            context?.showToast(uiState.throwable.message!!)
                        else -> {}
                    }
                }
        } ?: context?.showToast("Invalid data")
    }
}