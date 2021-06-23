package com.indialone.composepracticebottomnavigation.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.indialone.composepracticebottomnavigation.news.model.Articles
import com.indialone.composepracticebottomnavigation.news.model.NewsEntity
import com.indialone.composepracticebottomnavigation.viewmodel.NewsViewModel
import com.indialone.composepracticebottomnavigation.viewmodel.ViewModelFactory


@Composable
fun NewsMainScreen() {
    val newsViewModel = viewModel(
        factory = ViewModelFactory(),
        modelClass = NewsViewModel::class.java
    )

    // top headlines news entity
    val topHeadlinesNewsEntity: NewsEntity =
        newsViewModel.getTopHeadlinesNews().observeAsState(NewsEntity()).value

    // everything news entity
    val everythingNewsEntity: NewsEntity =
        newsViewModel.getEverythingNews().observeAsState(NewsEntity()).value

    // top headlines by sources news entity
    val topHeadlinesBySourcesNewsEntity: NewsEntity =
        newsViewModel.getTopHeadlinesBySourcesNews().observeAsState(NewsEntity()).value

    // everything by query news entity
    val everythingQueryNewsEntity: NewsEntity =
        newsViewModel.getEverythingQueryNews().observeAsState(NewsEntity()).value

    // everything by query to date news entity
    val everythingQueryToNewsEntity: NewsEntity =
        newsViewModel.getEverythingQueryToNews().observeAsState(NewsEntity()).value

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 5.dp)
    ) {



        item {
            Spacer(modifier = Modifier.height(10.dp))

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
                    text = "Top Headlines",
                    color = colorResource(id = R.color.colorPrimaryDark),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                topHeadlinesNewsEntity.articles?.let {
                    itemsIndexed(topHeadlinesNewsEntity.articles!!) { index, item ->
                        NewsItemLayout(item)
                        Spacer(modifier = Modifier
                            .height(20.dp)
                            .width(10.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {

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
                    text = "Top Headlines from TechCrunch",
                    color = colorResource(id = R.color.colorPrimaryDark),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                topHeadlinesBySourcesNewsEntity.articles?.let {
                    itemsIndexed(topHeadlinesBySourcesNewsEntity.articles!!) { index, item ->
                        NewsItemLayout(item)
                        Spacer(modifier = Modifier
                            .height(20.dp)
                            .width(10.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {

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
                    text = "Everything By Domain wsj.com",
                    color = colorResource(id = R.color.colorPrimaryDark),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                everythingNewsEntity.articles?.let {
                    itemsIndexed(everythingNewsEntity.articles!!) { index, item ->
                        NewsItemLayout(item)
                        Spacer(modifier = Modifier
                            .height(20.dp)
                            .width(10.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }


        item {
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
                    text = "Everything Today",
                    color = colorResource(id = R.color.colorPrimaryDark),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                everythingQueryNewsEntity.articles?.let {
                    itemsIndexed(everythingQueryNewsEntity.articles!!) { index, item ->
                        NewsItemLayout(item)
                        Spacer(modifier = Modifier
                            .height(20.dp)
                            .width(10.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
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
                    text = "Everything From 21-05-2021 to Today",
                    color = colorResource(id = R.color.colorPrimaryDark),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                everythingQueryToNewsEntity.articles?.let {
                    itemsIndexed(everythingQueryToNewsEntity.articles!!) { index, item ->
                        NewsItemLayout(item)
                        Spacer(modifier = Modifier
                            .height(20.dp)
                            .width(10.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Composable
fun NewsItemLayout(articles: Articles?) {
    articles?.let {
        Card(
            modifier = Modifier
                .width(250.dp)
                .height(400.dp),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = colorResource(id = R.color.colorSecondaryDark),
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = if (articles.title == null) "" else articles.title!!,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Author : " + if (articles.author == null) "" else articles.author,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Published At : ${articles.publishedAt!!}",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = rememberGlidePainter(request = articles.urlToImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
//                Spacer(modifier = Modifier.height(5.dp))
//                Text(
//                    text = if (articles.url == null) "" else articles.url!!,
//                    color = Color.LightGray,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Normal,
//                    fontFamily = FontFamily.SansSerif,
//                    overflow = TextOverflow.Ellipsis
//                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (articles.description == null) "" else articles.description!!,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (articles.content == null) "" else articles.content!!,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}