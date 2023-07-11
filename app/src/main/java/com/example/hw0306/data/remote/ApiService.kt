package com.example.hw0306.data.remote

import com.example.hw0306.data.model.PlaylistsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResults: Int = 10,

        ): Call<PlaylistsModel>
}