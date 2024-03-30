package com.project.liceriabakery.rvlistbakery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.liceriabakery.data.entity.MainEntity
import com.project.liceriabakery.databinding.ItemlistBinding

class ListAdapter(
    private val list: List<MainEntity>,
    private val onPhoneClick: (MainEntity) -> Unit
) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemlistBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onPhoneClick
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]

        holder.bind(data)
    }
}