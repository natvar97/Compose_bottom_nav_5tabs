package com.indialone.composepracticebottomnavigation.movies

data class Movie(
    var title : String,
    var imdb : String,
    var director : String,
    var image : Int,
    var actors : List<Actor>
)
