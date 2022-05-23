package ca.sudbury.hojat.photofinder.presentation

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ca.sudbury.hojat.photofinder.data.UnsplashPhoto
import ca.sudbury.hojat.photofinder.databinding.ListItemBinding
import com.bumptech.glide.Glide

/**
 * Created by Hojat Ghasemi at 2022-05-19
 * Contact the author at "https://github.com/hojat72elect"
 *
 * This adapter extends [PagingDataAdapter] in order to
 * support paged data in a RecyclerView.
 */
class HojatPhotosRecyclerViewAdapter constructor(
    private val clickListener: (UnsplashPhoto) -> Unit
) : PagingDataAdapter<UnsplashPhoto, HojatPhotosRecyclerViewAdapter.PhotoViewHolder>(COMPARATOR) {

    private val photosList = ArrayList<UnsplashPhoto>()


    companion object {
        // diff util comparator
        val COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areContentsTheSame(
                oldItem: UnsplashPhoto,
                newItem: UnsplashPhoto
            ): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean =
                oldItem == newItem
        }

    }

    /**
     * It's called by RecyclerView to display the data at the
     * specified position. This method should update the contents
     * of the [PhotoViewHolder] to reflect the item at the given
     * position.
     */
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photosList[position], clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        // Here we create each item of the recycler view.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    /**
     * Reloads all the items in the recycler view (use it whenever you
     * want the recycler view to be loaded from scratch)
     * */
    fun setList(photos: List<UnsplashPhoto>) {
        photosList.clear()
        photosList.addAll(photos)
    }


    class PhotoViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: UnsplashPhoto, clickListener: (UnsplashPhoto) -> Unit) {
            Log.d("unsplash_photo_url", photo.links.self)
            Glide.with(binding.root.context)
                .load(Uri.parse(photo.links.self))
                .into(binding.imageView)

            binding.listItemLayout.setOnClickListener {
                clickListener(photo)
            }

        }
    }

}