package com.project.liceriabakery.rvlistbakery

import androidx.recyclerview.widget.RecyclerView
import com.project.liceriabakery.data.entity.MainEntity
import com.project.liceriabakery.databinding.ItemlistBinding

class ListViewHolder(
    private val binding: ItemlistBinding,
    private val onPhoneClick: (MainEntity) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MainEntity) {
        binding.name.text = data.name
        binding.alamat.text = data.stock
        binding.fasilitas.text = data.harga

        val resources = binding.root.context.resources
        val imageId = resources.getIdentifier(data.images, "drawable", binding.root.context.packageName)
        binding.PosterIV.setImageResource(imageId)
        binding.wa.setOnClickListener { onPhoneClick(data) }
    }
}