package ca.sudbury.hojat.photofinder.presentation

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.R
import ca.sudbury.hojat.photofinder.databinding.ListItemBinding
import com.bumptech.glide.Glide

/**
 * Created by Hojat Ghasemi at 2022-04-27
 * Contact the author at "https://github.com/hojat72elect"
 */
class PhotosRecyclerViewAdapter(
    private val clickListener: (Photo) -> Unit
) : RecyclerView.Adapter<PhotoViewHolder>() {

    private val photosList = ArrayList<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        // here we create each item of the recycler view.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photosList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    /**
     * reloads all the items in the recycler view (use it whenever you   * want the recycler view to be loaded from scratch)
     * */

    fun setList(photos: List<Photo>) {
        photosList.clear()
        photosList.addAll(photos)
    }

}


class PhotoViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: Photo, clickListener: (Photo) -> Unit) {
        Glide.with(binding.root.context)
            .load(Uri.parse(photo.url_regular))
            .into(binding.imageView)

        binding.listItemLayout.setOnClickListener {
            clickListener(photo)
        }
    }
}