package ca.sudbury.hojat.photofinder.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.sudbury.hojat.photofinder.ListItemClickListener
import ca.sudbury.hojat.photofinder.data.datamodel.Photo
import ca.sudbury.hojat.photofinder.databinding.PopularPhotosItemBinding
import ca.sudbury.hojat.photofinder.loadUrl
import kotlin.properties.Delegates

/**
 * Adapter class for list of popular photos
 * @author Prasan
 *
 */
class PopularPhotosAdapter(
    private val itemClickListener: ListItemClickListener<Photo>
) :
    RecyclerView.Adapter<PopularPhotosAdapter.PopularPhotosViewHolder>() {

    var itemList: List<Photo> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularPhotosViewHolder =
        PopularPhotosViewHolder(PopularPhotosItemBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: PopularPhotosViewHolder, position: Int) {

        val photo = itemList[position]
        holder.bind(photo)
        holder.itemView.setOnClickListener { itemClickListener(photo) }
    }

    override fun getItemCount() = itemList.size

    /**
     * ViewHolder class for [PopularPhotosAdapter]
     * @author Prasan
     * @since 1.0
     */
    class PopularPhotosViewHolder(private val binding: PopularPhotosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.popularPhoto.loadUrl(photo.images[0].httpsUrl)
        }
    }
}