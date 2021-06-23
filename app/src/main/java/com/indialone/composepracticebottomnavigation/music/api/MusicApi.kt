package com.indialone.composepracticebottomnavigation.music.api

import com.indialone.composepracticebottomnavigation.music.model.AlbumsEntity
import com.indialone.composepracticebottomnavigation.music.model.ArtistEntity
import com.indialone.composepracticebottomnavigation.music.model.TrackEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MusicApi {



    @GET("tracks/top")
    suspend fun getAllTracks(@Query("apikey") apiKey : String) : TrackEntity

    @GET("albums/new")
    suspend fun getAllAlbums(@Query("apiKey") apiKey: String) : AlbumsEntity

}