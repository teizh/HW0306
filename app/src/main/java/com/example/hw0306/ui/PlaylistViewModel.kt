package com.example.hw0306.ui

import androidx.lifecycle.LiveData
import com.example.hw0306.core.base.BaseViewModel
import com.example.hw0306.core.network.Resource
import com.example.hw0306.data.model.PlaylistsModel
import com.example.hw0306.repository.Repository

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    fun playlists(): LiveData<Resource<PlaylistsModel>> {
        return repository.getPlayLists()
    }
}