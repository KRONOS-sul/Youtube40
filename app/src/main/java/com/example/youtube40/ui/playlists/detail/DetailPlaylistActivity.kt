package com.example.youtube40.ui.playlists.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtube40.R
import com.example.youtube40.`object`.Constant
import com.example.youtube40.base.BaseActivity
import com.example.youtube40.databinding.ActivityDetailPlaylistBinding
import com.example.youtube40.databinding.ActivityPlaylistsBinding

class DetailPlaylistActivity : BaseActivity<DetailViewModel, ActivityDetailPlaylistBinding>() {

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailPlaylistBinding {
        return ActivityDetailPlaylistBinding.inflate(inflater)
    }

    override fun initView() {
        Toast.makeText(
            this,
            "albert pidor${intent.getStringExtra(Constant.KEY)}",
            Toast.LENGTH_SHORT
        ).show()
    }

}