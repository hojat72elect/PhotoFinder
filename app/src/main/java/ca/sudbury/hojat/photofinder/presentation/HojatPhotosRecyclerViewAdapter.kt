package ca.sudbury.hojat.photofinder.presentation

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.sudbury.hojat.photofinder.data.UnsplashPhoto
import ca.sudbury.hojat.photofinder.databinding.ListItemBinding
import com.bumptech.glide.Glide

/**
 * Created by Hojat Ghasemi at 2022-05-19
 * Contact the author at "https://github.com/hojat72elect"
 *
 * todo: this RecyclerView.Adapter needs to be changed in
 *  a way that it can support paged data.
 */
class HojatPhotosRecyclerViewAdapter(
    private val clickListener: (UnsplashPhoto) -> Unit
) : RecyclerView.Adapter<PhotoViewHolder>() {

    private val photosList = ArrayList<UnsplashPhoto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        // Here we create each item of the recycler view.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return PhotoViewHolder(binding)
    }

    /**
     * It's called by RecyclerView to display the data at the
     * specified position. This method should update the contents
     * of the [ViewHolder] to reflect the item at the given
     * position.
     */
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photosList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    /**
     * Reloads all the items in the recycler view (use it whenever you
     * want the recycler view to be loaded from scratch)
     * */
    fun setList(photos:List<UnsplashPhoto>) {
        photosList.clear()
        photosList.addAll(photos)
    }


}

class PhotoViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: UnsplashPhoto, clickListener: (UnsplashPhoto) -> Unit) {
        Glide.with(binding.root.context)
            .load(Uri.parse(photo.links.self))
            .into(binding.imageView)

        binding.listItemLayout.setOnClickListener {
            clickListener(photo)
        }

    }
}