package ca.sudbury.hojat.photofinder.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ca.sudbury.hojat.photofinder.*
import ca.sudbury.hojat.photofinder.data.datamodel.Photo
import ca.sudbury.hojat.photofinder.data.datamodel.PhotoDetails
import ca.sudbury.hojat.photofinder.databinding.PopularPhotosFragmentBinding
import ca.sudbury.hojat.photofinder.presentation.MainViewModel
import ca.sudbury.hojat.photofinder.presentation.PopularPhotosAdapter

/**
 * This [Fragment] displays a list of popular photos from 500px in a paginated fashion, the next page of data
 * is loaded when the scrolling of the current list of items is at its end. On loading, the API calls the first
 * page of data.
 * @author Hojat Ghasemi
 */
class PopularPhotosFragment : Fragment() {

    private val myViewModel: MainViewModel by activityViewModels() // todo: the view model is not initialized correctly.
    private lateinit var binding: PopularPhotosFragmentBinding
    private val photoItemClickListener: ListItemClickListener<Photo> = {
        val photoDetails = PhotoDetails(
            it.images[0].httpsUrl,
            it.description,
            it.votesCount,
            it.commentsCount,
            it.rating,
            it.timesViewed,
            it.name,
            it.user?.fullname,
            it.user?.avatars?.default?.https,
            it.getFormattedExifData(),
            it.durationPosted()
        )
        findNavController()
            .navigate(
                PopularPhotosFragmentDirections
                    .actionPopularPhotosFragmentToPhotoDetailsFragment(photoDetails)
            )
        myViewModel.navigatingFromDetails = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PopularPhotosFragmentBinding.inflate(inflater)
        retainInstance = true
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.popularPhotoList.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    myViewModel.onRecyclerViewScrolledToBottom()
                }
            }
        })

        myViewModel.popularPhotosLiveData.observe(viewLifecycleOwner) { viewState ->
            // todo: the view model used above is not initialized correctly.
            when (viewState) {

                is ViewState.Loading ->
                    binding.loading.visibility =
                        if (viewState.isLoading) View.VISIBLE else View.GONE

                is ViewState.RenderFailure ->
                    viewState.throwable.message?.let { toastMessage ->
                        context?.showToast(toastMessage)
                    }

                is ViewState.RenderSuccess -> {

                    if (binding.popularPhotoList.adapter == null) {
                        binding.popularPhotoList.adapter = PopularPhotosAdapter(
                            photoItemClickListener
                        )
                    }

                    (binding.popularPhotoList.adapter as PopularPhotosAdapter).itemList =
                        viewState.output
                }
            }
        }
        myViewModel.getPhotosNextPage()
    }
}