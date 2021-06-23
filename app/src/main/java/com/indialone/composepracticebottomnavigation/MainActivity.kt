package com.indialone.composepracticebottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.indialone.composepracticebottomnavigation.home.DetailsScreen
import com.indialone.composepracticebottomnavigation.navigation.*
import com.indialone.composepracticebottomnavigation.ui.theme.ComposePracticeBottomNavigationTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeBottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Music.route) {
            MusicScreen()
        }
        composable(NavigationItem.Movies.route) {
            MoviesScreen()
        }
        composable(NavigationItem.Books.route) {
            BooksScreen()
        }
        composable(NavigationItem.News.route) {
            NewsScreen()
        }
        composable(
            "details/{countryName}",
            arguments = listOf(navArgument("countryName") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("countryName")?.let { countryName ->
                DetailsScreen(countryName = countryName)
            }
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        contentColor = Color.White,
        title = {
            Text(
                text = stringResource(id = R.string.app_name_top_bar),
                fontSize = 18.sp,
            )
        },
        backgroundColor = colorResource(id = R.color.colorPrimary)
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Music,
        NavigationItem.Movies,
        NavigationItem.Books,
        NavigationItem.News
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .height(30.dp)
                            .width(40.dp)
                            .padding(bottom = 5.dp)
                    )
                },
                label = {
                    Text(text = item.title, fontSize = 16.sp)
                },
                selectedContentColor = colorResource(id = R.color.colorSecondaryDark),
                unselectedContentColor = Color.Black,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true

                    }
                }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeBottomNavigationTheme {
        TopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    ComposePracticeBottomNavigationTheme {
        val navController = rememberNavController()
        BottomNavigationBar(navController)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    ComposePracticeBottomNavigationTheme {
//        MainScreen()
//    }
//}