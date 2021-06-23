package com.indialone.composepracticebottomnavigation.repository

import androidx.annotation.WorkerThread
import com.indialone.composepracticebottomnavigation.music.api.RetrofitBuilderMusic
import com.indialone.composepracticebottomnavigation.utils.Constants

class MusicRepository {

    @WorkerThread
    suspend fun getAllTracks() = RetrofitBuilderMusic
        .getInstanceOfMusicApi()
        .getAllTracks(Constants.MUSIC_API_KEY)


    @WorkerThread
    suspend fun getAllAlbums() = RetrofitBuilderMusic
        .getInstanceOfMusicApi()
        .getAllAlbums(Constants.MUSIC_API_KEY)

}