package com.example.hw0306.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw0306.BuildConfig
import com.example.hw0306.core.network.Resource
import com.example.hw0306.core.network.RetrofitClient
import com.example.hw0306.data.model.PlaylistsModel
import com.example.hw0306.data.remote.ApiService
import com.example.hw0306.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService = RetrofitClient.create()
    fun getPlayLists(): LiveData<Resource<PlaylistsModel>> {
        val data = MutableLiveData<Resource<PlaylistsModel>>()
        data.value = Resource.loading()
        apiService.getPlaylists(
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            apiKey = BuildConfig.API_KEY,
            maxResults = 10
        ).enqueue(object : Callback<PlaylistsModel> {
            override fun onResponse(
                call: Call<PlaylistsModel>, response: Response<PlaylistsModel>
            ) {
                if (response.isSuccessful) {
                    data.value = Resource.success(response.body())
                }
            }

            override fun onFailure(call: Call<PlaylistsModel>, t: Throwable) {
                Resource.error(t.message.toString(), null)
            }

        })
        return data
    }

}