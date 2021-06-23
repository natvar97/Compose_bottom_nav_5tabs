package com.indialone.composepracticebottomnavigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.composepracticebottomnavigation.news.model.NewsEntity
import com.indialone.composepracticebottomnavigation.repository.NewsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val topHeadlinesNewsList = MutableLiveData<NewsEntity>()
    private val everythingNewsList = MutableLiveData<NewsEntity>()
    private val topHeadlinesBySourcesNewsList = MutableLiveData<NewsEntity>()
    private val everythingQueryNewsList = MutableLiveData<NewsEntity>()
    private val everythingQueryToNewsList = MutableLiveData<NewsEntity>()

    init {
        fetchTopHeadlinesNews()
        fetchEverythingNews()
        fetchTopHeadlinesNewsBySources()
        fetchEverythingQuery()
        fetchEverythingQueryTo()
    }

    private fun fetchEverythingNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getNewsEverything()
                    }
                    everythingNewsList.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchTopHeadlinesNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getNewsTopHeadlines()
                    }
                    topHeadlinesNewsList.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchEverythingQueryTo() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getNewsEverythingQueryTo()
                    }
                    everythingQueryToNewsList.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchEverythingQuery() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getNewsEverythingQuery()
                    }
                    everythingQueryNewsList.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchTopHeadlinesNewsBySources() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getNewsTopHeadlinesBySources()
                    }
                    topHeadlinesBySourcesNewsList.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getTopHeadlinesNews() : LiveData<NewsEntity> {
        return topHeadlinesNewsList
    }

    fun getEverythingNews(): LiveData<NewsEntity> {
        return everythingNewsList
    }

    fun getTopHeadlinesBySourcesNews(): LiveData<NewsEntity> {
        return topHeadlinesBySourcesNewsList
    }

    fun getEverythingQueryNews(): LiveData<NewsEntity> {
        return everythingQueryNewsList
    }

    fun getEverythingQueryToNews() : LiveData<NewsEntity> {
        return everythingQueryToNewsList
    }

}