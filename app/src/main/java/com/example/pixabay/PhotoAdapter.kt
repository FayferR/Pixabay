package com.example.pixabay


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabay.databinding.ItemImageBinding
import com.example.pixabay.model.ImageModel

class PhotoAdapter(private val list: ArrayList<ImageModel>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.photoImg.load(imageModel.largeImageURL)
        }

    }
    fun addImage(image:ImageModel){
        list.add(image)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
          ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBind(list[position])
    }
    override fun getItemCount(): Int {
        return list.size
    }
}