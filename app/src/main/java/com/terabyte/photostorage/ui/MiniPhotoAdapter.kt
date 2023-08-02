package com.terabyte.photostorage.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.terabyte.photostorage.activity.FullPhotoActivity
import com.terabyte.photostorage.databinding.ItemMiniPhotoBinding

class MiniPhotoAdapter(private val context: Context,
                       private val miniPhotos: List<MiniPhoto>):
    RecyclerView.Adapter<MiniPhotoAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemMiniPhotoBinding.inflate(LayoutInflater.from(context)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder.binding) {
            imageMiniPhoto.setImageURI(miniPhotos[position].uri)
            imageMiniPhoto.setOnClickListener {
                startFullPhotoActivity()
            }
        }
    }

    override fun getItemCount() = miniPhotos.size

    private fun startFullPhotoActivity() {
        context.startActivity(Intent(context, FullPhotoActivity::class.java))
    }

    inner class Holder(val binding: ItemMiniPhotoBinding): RecyclerView.ViewHolder(binding.root) {

    }
}