package com.example.hw0306.ui

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.hw0306.core.base.BaseActivity
import com.example.hw0306.core.network.Resource
import com.example.hw0306.data.model.PlaylistsModel
import com.example.hw0306.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListsActivity : BaseActivity<ActivityMainBinding, PlaylistViewModel>() {

    private var adapter = AdapterPlayLists(this::onClick)


    override val viewModel: PlaylistViewModel by viewModel()

    override fun inflateViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun setupLiveData() {
        super.setupLiveData()
        viewModel.playlists().observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { it1 ->
                        adapter.setList(it1.items)
                    }
                    binding.recyclerView.adapter = adapter
                    Toast.makeText(this, it.data?.kind ?: "null", Toast.LENGTH_SHORT).show()
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    Log.e("ololo", "setupLiveData: ${it.message}")
                }

                Resource.Status.LOADING -> Toast.makeText(this, "loading", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun onClick(item: PlaylistsModel.Item) {
   /*     val intent = Intent(this, DetailPlaylistActivity::class.java)
        intent.putExtra("title", item.snippet.title)
        intent.putExtra("desc", item.snippet.description)
        intent.putExtra("id", item.id)
        intent.putExtra("count", item.contentDetails.itemCount)
        startActivity(intent)*/
    }
}