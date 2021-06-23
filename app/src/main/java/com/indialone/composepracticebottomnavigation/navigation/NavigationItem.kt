package com.indialone.composepracticebottomnavigation.navigation

import com.indialone.composepracticebottomnavigation.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.icon_home, "Home")
    object Music : NavigationItem("music", R.drawable.icon_music, "Music")
    object Movies : NavigationItem("movies", R.drawable.icon_movies, "Movies")
    object Books : NavigationItem("books", R.drawable.icon_book, "Books")
    object News : NavigationItem("news", R.drawable.icon_news, "News")
}
