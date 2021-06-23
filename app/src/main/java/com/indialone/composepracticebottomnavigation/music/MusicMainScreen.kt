package com.indialone.composepracticebottomnavigation.music

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.glide.rememberGlidePainter
import com.indialone.composepracticebottomnavigation.R
import com.indialone.composepracticebottomnavigation.music.model.*
import com.indialone.composepracticebottomnavigation.viewmodel.MusicViewModel
import com.indialone.composepracticebottomnavigation.viewmodel.ViewModelFactory

@ExperimentalFoundationApi
@Composable
fun MusicMainScreen() {

    val musicViewModel = viewModel(
        factory = ViewModelFactory(),
        modelClass = MusicViewModel::class.java
    )

    val allTracks: TrackEntity = musicViewModel.getAllTracks().observeAsState(TrackEntity()).value

    Log.e("all tracks", "$allTracks")

    val allAlbums: AlbumsEntity =
        musicViewModel.getAllAlbums().observeAsState(AlbumsEntity()).value

    Log.e("all artists", "$allAlbums")

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 5.dp)
    ) {
//
//
//        item {
//            Spacer(modifier = Modifier.height(10.dp))

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
                text = "Tracks",
                color = colorResource(id = R.color.colorPrimaryDark),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(5.dp)
        ) {

            allTracks.tracks?.let {
                itemsIndexed(allTracks.tracks) { index, item ->
                    item?.let {
                        TrackItemLayout(item)
                    }

                }
            }
        }

//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(10.dp),
//            elevation = 20.dp,
//            backgroundColor = Color.White,
//            shape = RoundedCornerShape(20.dp)
//        ) {
//            Text(
//                text = "Artists",
//                color = colorResource(id = R.color.colorPrimaryDark),
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.padding(vertical = 20.dp)
//            )
//        }
//
//        LazyVerticalGrid(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            cells = GridCells.Fixed(2),
//            contentPadding = PaddingValues(5.dp)
//        ) {
//
//            allArtists.albums?.let {
//                itemsIndexed(allArtists.albums) { index, item ->
//                    item?.let {
//                        AlbumsItemLayout(item)
//                    }
//                }
//            }
//        }

//        item {
//
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//                    .padding(10.dp),
//                elevation = 20.dp,
//                backgroundColor = Color.White,
//                shape = RoundedCornerShape(20.dp)
//            ) {
//                Text(
//                    text = "Artists",
//                    color = colorResource(id = R.color.colorPrimaryDark),
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.padding(vertical = 20.dp)
//                )
//            }
//
//            Spacer(modifier = Modifier.height(10.dp))
//        }
//
//        item {
//            LazyRow(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                allArtists.artists?.let {
//                    itemsIndexed(allArtists.artists) { index, item ->
//                        item?.let {
//                            ArtistItemLayout(item)
//                            Spacer(
//                                modifier = Modifier
//                                    .height(20.dp)
//                                    .width(10.dp)
//                            )
//
//                        }
//                    }
//                }
//            }
//            Spacer(modifier = Modifier.height(10.dp))
//        }
//    }
    }
}

@Composable
fun AlbumsItemLayout(item: AlbumsItem) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = colorResource(id = R.color.colorSecondaryDark),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Artist: ${item.name!!}",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Account Partner: ${item.accountPartner!!}",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                textAlign = TextAlign.Start
            )


//            Spacer(modifier = Modifier.height(5.dp))
//
//            Text(
//                text = item.id!!,
//                color = Color.White,
//                fontSize = 16.sp,
//                fontFamily = FontFamily.SansSerif,
//                overflow = TextOverflow.Ellipsis,
//                fontWeight = FontWeight.Medium,
//                maxLines = 2,
//                textAlign = TextAlign.Start
//            )


            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Type: ${item.type!!}",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                textAlign = TextAlign.Start
            )


            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Links: ${item.links!!}",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                textAlign = TextAlign.Start
            )


//            Spacer(modifier = Modifier.height(5.dp))
//
//            Text(
//                text = item.href!!,
//                color = Color.White,
//                fontSize = 16.sp,
//                fontFamily = FontFamily.SansSerif,
//                overflow = TextOverflow.Ellipsis,
//                fontWeight = FontWeight.Medium,
//                maxLines = 2,
//                textAlign = TextAlign.Start
//            )

            Image(
                painter = rememberGlidePainter(request = item.href),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(20.dp))
            )

        }
    }
}

@Composable
fun TrackItemLayout(item: TracksItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(5.dp),
        backgroundColor = colorResource(id = R.color.colorSecondaryDark),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Artist: ${item.artistName!!}",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Album: ${item.albumName!!}",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                textAlign = TextAlign.Start
            )


//            Spacer(modifier = Modifier.height(5.dp))
//
//            Text(
//                text = item.artistId!!,
//                color = Color.White,
//                fontSize = 16.sp,
//                fontFamily = FontFamily.SansSerif,
//                overflow = TextOverflow.Ellipsis,
//                fontWeight = FontWeight.Medium,
//                maxLines = 2,
//                textAlign = TextAlign.Start
//            )
//
//
//            Spacer(modifier = Modifier.height(5.dp))
//
//            Text(
//                text = item.albumId!!,
//                color = Color.White,
//                fontSize = 16.sp,
//                fontFamily = FontFamily.SansSerif,
//                overflow = TextOverflow.Ellipsis,
//                fontWeight = FontWeight.Medium,
//                maxLines = 2,
//                textAlign = TextAlign.Start
//            )


            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Song: ${item.name!!}",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                textAlign = TextAlign.Start
            )


//            Spacer(modifier = Modifier.height(5.dp))
//
//            Text(
//                text = item.href!!,
//                color = Color.White,
//                fontSize = 16.sp,
//                fontFamily = FontFamily.SansSerif,
//                overflow = TextOverflow.Ellipsis,
//                fontWeight = FontWeight.Medium,
//                maxLines = 2,
//                textAlign = TextAlign.Start
//            )
//
//            Image(
//                painter = rememberGlidePainter(request = item.href),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp)
//                    .clip(RoundedCornerShape(20.dp))
//            )

        }
    }
}