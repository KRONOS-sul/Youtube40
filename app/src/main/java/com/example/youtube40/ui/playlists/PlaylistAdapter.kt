package com.example.youtube40.ui.playlists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube40.common.extensions.loadWithGlide
import com.example.youtube40.databinding.ItemPlaylistBinding
import com.example.youtube40.model.Item
import com.example.youtube40.model.Playlist

class PlaylistAdapter(private val onItemCLick: (id: String) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private var list = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: ArrayList<Item>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Item) {
            item.snippet?.thumbnails?.maxres?.url?.let { binding.imBanner.loadWithGlide(it) }
            binding.tvThemes.text = item.snippet?.title.toString()
            (item.contentDetails?.itemCount.toString() + " video series").also {
                binding.tvCountVideo.text = it
            }
            binding.root.setOnClickListener {
                onItemCLick(item.id.toString())
            }
        }

    }

}