package com.indialone.composepracticebottomnavigation.repository

import androidx.annotation.WorkerThread
import com.indialone.composepracticebottomnavigation.news.api.RetrofitBuilder
import com.indialone.composepracticebottomnavigation.utils.Constants

class NewsRepository {

    @WorkerThread
    suspend fun getNewsTopHeadlines() = RetrofitBuilder
        .getInstanceOfNewsApi()
        .getNewsTopHeadlines(
            Constants.COUNTRY,
            Constants.CATEGORY,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getNewsEverything() = RetrofitBuilder
        .getInstanceOfNewsApi()
        .getNewsEverything(
            Constants.DOMAINS,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getNewsTopHeadlinesBySources() = RetrofitBuilder
        .getInstanceOfNewsApi()
        .getNewsTopHeadlinesBySources(
            Constants.SOURCES,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getNewsEverythingQuery() = RetrofitBuilder
        .getInstanceOfNewsApi()
        .getNewsEverythingQuery(
            Constants.Q_TESLA,
            Constants.TO,
            Constants.SORT_BY_PUBLISHED_AT,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getNewsEverythingQueryTo() = RetrofitBuilder
        .getInstanceOfNewsApi()
        .getNewsEverythingQueryTo(
            Constants.Q_APPLE,
            Constants.TO,
            Constants.FROM,
            Constants.SORT_BY_POPULARITY,
            Constants.API_KEY
        )

}