package com.indialone.composepracticebottomnavigation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.indialone.composepracticebottomnavigation.R
import com.indialone.composepracticebottomnavigation.books.BookMainScreen
import com.indialone.composepracticebottomnavigation.home.HomeMainScreen
import com.indialone.composepracticebottomnavigation.movies.MovieMainScreen
import com.indialone.composepracticebottomnavigation.music.MusicMainScreen
import com.indialone.composepracticebottomnavigation.news.NewsMainScreen

@Composable
fun HomeScreen(navController: NavController) {

    HomeMainScreen(navController = navController)
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.colorPrimaryDark))
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text = "Home View",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 25.sp
//        )
//    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}

@ExperimentalFoundationApi
@Composable
fun MusicScreen() {

    MusicMainScreen()

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.colorPrimaryDark))
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text = "Music View",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 25.sp
//        )
//    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun MusicScreenPreview() {
    MusicScreen()
}

@Composable
fun MoviesScreen() {

    MovieMainScreen()

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.colorPrimaryDark))
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text = "Movies View",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 25.sp
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    MoviesScreen()
}


@Composable
fun BooksScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.colorPrimaryDark))
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text = "Books View",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 25.sp
//        )
//    }

    BookMainScreen()
}

@Preview(showBackground = true)
@Composable
fun BooksScreenPreview() {
    BooksScreen()
}

@Composable
fun NewsScreen() {
    NewsMainScreen()
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.colorPrimaryDark))
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text = "Profile View",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 25.sp
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    NewsScreen()
}