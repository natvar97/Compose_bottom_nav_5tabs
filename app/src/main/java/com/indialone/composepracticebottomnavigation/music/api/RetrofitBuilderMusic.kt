package com.indialone.composepracticebottomnavigation.music.api

import com.indialone.composepracticebottomnavigation.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderMusic {

    fun getInstanceOfMusicApi(): MusicApi {
        return Retrofit.Builder()
            .baseUrl(Constants.MUSIC_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicApi::class.java)
    }

}