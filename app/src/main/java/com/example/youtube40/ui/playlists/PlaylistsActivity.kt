package com.example.youtube40.ui.playlists

import android.content.Intent
import android.view.LayoutInflater
import android.view.WindowId
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube40.`object`.Constant
import com.example.youtube40.base.BaseActivity
import com.example.youtube40.databinding.ActivityPlaylistsBinding
import com.example.youtube40.model.Item
import com.example.youtube40.ui.checkinternet.ConnectivityStatus
import com.example.youtube40.ui.playlists.detail.DetailPlaylistActivity

class PlaylistsActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistsBinding>() {

    private lateinit var checkInet: ConnectivityStatus
    private val adapter = PlaylistAdapter(this::onItemClick)

    private fun onItemClick(id: String) {
        val intent = Intent(this, DetailPlaylistActivity::class.java)
        intent.putExtra(Constant.KEY, id)
        startActivity(intent)
    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initView() {
        binding.recycler.adapter = adapter
    }

    override fun initViewModel() {
        viewModel.getPlaylists().observe(this) {
            adapter.setList(it.items as ArrayList<Item>)
        }
    }

    override fun checkInternet() {
        checkInet = ConnectivityStatus(this)
        checkInet.observe(this) { internet ->
            if (internet == true) {
                binding.layoutInternet.root.isVisible = false
                binding.recycler.isVisible = true
                initViewModel()
            } else {
                binding.layoutInternet.root.isVisible = true
                binding.recycler.isVisible = false
            }

        }

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(inflater)
    }
}