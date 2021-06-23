package com.indialone.composepracticebottomnavigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indialone.composepracticebottomnavigation.repository.MusicRepository
import com.indialone.composepracticebottomnavigation.repository.NewsRepository
import java.lang.IllegalArgumentException

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(NewsRepository()) as T
        }
        if (modelClass.isAssignableFrom(MusicViewModel::class.java)) {
            return MusicViewModel(MusicRepository()) as T
        }
        throw IllegalArgumentException("Unknown view model class found ")
    }
}