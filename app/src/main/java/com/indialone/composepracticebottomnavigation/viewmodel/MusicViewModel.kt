package com.indialone.composepracticebottomnavigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.composepracticebottomnavigation.music.model.AlbumsEntity
import com.indialone.composepracticebottomnavigation.repository.MusicRepository
import com.indialone.composepracticebottomnavigation.music.model.ArtistEntity
import com.indialone.composepracticebottomnavigation.music.model.TrackEntity
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MusicViewModel(
    private val musicRepository: MusicRepository
) : ViewModel() {

    val allTracks = MutableLiveData<TrackEntity>()

    val allArtists = MutableLiveData<AlbumsEntity>()

    init {
        fetchAllTracks()
        fetchAllAlbums()
    }

    private fun fetchAllTracks() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val tracks = async {
                        musicRepository.getAllTracks()
                    }
                    allTracks.postValue(tracks.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchAllAlbums() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val albums = async {
                        musicRepository.getAllAlbums()
                    }
                    allArtists.postValue(albums.await())
                }
            } catch (e : Exception) {}
        }
    }

    fun getAllTracks() : LiveData<TrackEntity> {
        return allTracks
    }

    fun getAllAlbums() : LiveData<AlbumsEntity> {
        return allArtists
    }


}