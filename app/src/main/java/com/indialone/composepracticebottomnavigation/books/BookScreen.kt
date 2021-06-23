package com.indialone.composepracticebottomnavigation.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import com.indialone.composepracticebottomnavigation.MainScreen
import com.indialone.composepracticebottomnavigation.R
import com.indialone.composepracticebottomnavigation.ui.theme.ComposePracticeBottomNavigationTheme

@Composable
fun BookMainScreen() {

    val books = listOf<Book>(
        Book(
            stringResource(id = R.string.and_there_were_none),
            stringResource(id = R.string.author_agatha),
            R.drawable.img_and_then_there_were_none_by_agatha_christie
        ),
        Book(
            stringResource(id = R.string.big_sleep),
            stringResource(id = R.string.author_raymond),
            R.drawable.the_big_sleep_by_raymond_chandler
        ),
        Book(
            stringResource(id = R.string.gone_girl),
            stringResource(id = R.string.gillian_flynn),
            R.drawable.gone_girl_by_gillian_flunn
        ),
        Book(
            stringResource(id = R.string.the_postman_always_rings_twice),
            stringResource(id = R.string.james_m_cain),
            R.drawable.the_postman_always_rings_twice_by_james_m_cain
        ),
        Book(
            stringResource(id = R.string.in_cold_blood),
            stringResource(id = R.string.author_truman_capote),
            R.drawable.in_cold_blood_by_truman_capote
        ),
        Book(
            stringResource(id = R.string.woman_in_white),
            stringResource(id = R.string.author_wilkie_collins),
            R.drawable.woman_in_white_by_wilkie_collins
        ),
        Book(
            stringResource(id = R.string.anotomy_of_murder),
            stringResource(id = R.string.author_robert_traver),
            R.drawable.anatomy_of_a_murder_by_robert_traver
        ),
        Book(
            stringResource(id = R.string.tinker_tailor_soldier_spy),
            stringResource(id = R.string.author_john_carre),
            R.drawable.tinker_tailor_soldier_spy_by_john_le_carre
        ),
        Book(
            stringResource(id = R.string.the_da_vinci_code),
            stringResource(id = R.string.author_dan_brown),
            R.drawable.the_da_vinci_code_by_dan_brown
        ),
        Book(
            stringResource(id = R.string.the_girl_with_dragon_tattoo),
            stringResource(id = R.string.author_stieg_larsson),
            R.drawable.the_girl_with_the_dragon_tatoo_by_stieg_larsson
        ),
        Book(
            stringResource(id = R.string.the_daughter_of_time),
            stringResource(id = R.string.author_josephine_tey),
            R.drawable.the_daughter_of_time_by_josephine_tey
        ),
        Book(
            stringResource(id = R.string.rebecca),
            stringResource(id = R.string.author_daphne_du_maurier),
            R.drawable.rebecca_by_daphne_du_maurier
        ),
        Book(
            stringResource(id = R.string.the_maltese_falcon),
            stringResource(id = R.string.author_dashiell_hammett),
            R.drawable.the_maltese_falcon_by_dashiell_hammett
        ),
        Book(
            stringResource(id = R.string.the_day_of_the_jackal),
            stringResource(id = R.string.author_frederick_forsyth),
            R.drawable.the_day_of_the_jackal_by_frederick_forsyth
        ),
        Book(
            stringResource(id = R.string.big_little_lies),
            stringResource(id = R.string.author_liane_moriarty),
            R.drawable.big_little_lies_by_liane_moriarty
        ),
        Book(
            stringResource(id = R.string.in_the_woods),
            stringResource(id = R.string.author_tana_french),
            R.drawable.in_the_woods_byu_tana_french
        ),
        Book(
            stringResource(id = R.string.the_silence_of_lambs),
            stringResource(id = R.string.author_thomas_harris),
            R.drawable.the_silence_of_the_lambs_by_thomas_harris
        ),
        Book(
            stringResource(id = R.string.the_hound_baskervilles),
            stringResource(id = R.string.author_arthur_conan_doyle),
            R.drawable.the_hound_of_the_baskervilles_by_sir_arthur_conan_doyle
        ),
        Book(
            stringResource(id = R.string.the_moonstone),
            stringResource(id = R.string.author_wilkie_collins),
            R.drawable.the_moonstone_by_wilkie_collins
        ),
        Book(
            stringResource(id = R.string.the_girl_on_train),
            stringResource(id = R.string.author_paula_hawkins),
            R.drawable.the_girl_on_the_train_by_paula_hawkins
        ),
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
                text = "Top 20 World Famous Books",
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
            itemsIndexed(books) { index, book ->
                BookItemLayout(book = book)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun BookItemLayout(book: Book) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        backgroundColor = colorResource(id = R.color.colorSecondaryDark),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            Image(
                painter = rememberGlidePainter(request = book.icon),
                contentDescription = null,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = book.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "By ${book.author}",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookItemLayoutPreview() {
    ComposePracticeBottomNavigationTheme {
        val book = Book(
            stringResource(id = R.string.and_there_were_none),
            stringResource(id = R.string.author_agatha),
            R.drawable.img_and_then_there_were_none_by_agatha_christie
        )

        BookItemLayout(book)
    }
}
