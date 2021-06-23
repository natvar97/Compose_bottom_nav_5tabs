package com.indialone.composepracticebottomnavigation.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import com.indialone.composepracticebottomnavigation.R
import com.indialone.composepracticebottomnavigation.books.BookItemLayout


@Composable
fun MovieMainScreen() {

    val master_actors = listOf(
        Actor(stringResource(id = R.string.master_actor1), R.drawable.master_vijay),
        Actor(stringResource(id = R.string.master_actor2), R.drawable.master_malavika),
        Actor(stringResource(id = R.string.master_actor3), R.drawable.master_vijay_sethupati),
        Actor(stringResource(id = R.string.master_actor4), R.drawable.master_arjun_das),
        Actor(stringResource(id = R.string.master_actor5), R.drawable.master_malavika),
    )

    val movies = listOf(
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
        Movie(stringResource(id = R.string.movie_master), stringResource(id = R.string.master_imdb), stringResource(id = R.string.master_director), R.drawable.master_poster, master_actors),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            elevation = 20.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "Top 10 Movies",
                color = colorResource(id = R.color.colorPrimaryDark),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(5.dp)
        ) {
            itemsIndexed(movies) { index, movie ->
                MovieListItem(movie)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun MovieListItem(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        backgroundColor = colorResource(id = R.color.colorSecondaryDark),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = rememberGlidePainter(request = movie.image),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = movie.title,
                    fontSize = 20.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "IMDb: ${movie.imdb}",
                    fontSize = 16.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Director: ${movie.director}",
                    fontSize = 16.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow {
                    itemsIndexed(movie.actors) { index, actor ->
                        ActorItem(actor = actor)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }

            }

        }
    }
}

@Composable
fun ActorItem(actor: Actor) {
    Column(
        modifier = Modifier
            .width(80.dp)
            .height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberGlidePainter(request = actor.image),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )

        Text(
            text = actor.name,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
            maxLines = 2,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        )

    }
}