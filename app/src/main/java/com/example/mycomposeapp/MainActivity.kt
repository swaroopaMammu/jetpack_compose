package com.example.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycomposeapp.model.ApplicationData
import com.example.mycomposeapp.model.ApplicationData.toMovieModelList
import com.example.mycomposeapp.model.MoviesModel
import com.example.mycomposeapp.screens.DetailedMovieScreen
import com.example.mycomposeapp.screens.HomeScreen
import com.example.mycomposeapp.screens.MovieListScreen
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   NavigationMap()
               }
            }
        }
    }
}

@Composable
fun NavigationMap(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
              composable("home") {
                  HomeScreen(categoryClick = {
                      navController.navigate("movielistscreen/title=${it}")
//                      if(it == "Favourite"){
//                          navController.navigate("movielistscreen/title=${it}/movieList=${ApplicationData.favouriteMovieList}")
//                      }else{
//                          navController.navigate("movielistscreen/title=${it}/movieList=${ApplicationData.animationMovieList}")
//                      }
                  })
              }
              composable("detail/movie={id}",
                  arguments = listOf(
//                      navArgument("movie"){
//                          type = NavType.ParcelableType(MoviesModel::class.java)
//                      }
                      navArgument("id"){
                          type = NavType.IntType
                      }
                  )
                  ) {
                  backStack ->
                     val arg = requireNotNull(backStack.arguments)
                 // val movie = arg.getParcelable("movie")?:MoviesModel()
                  val id = arg.getInt("id")
                  val movie = ApplicationData.animationMovieList.find { it.movieId == id } ?:
                  ApplicationData.favouriteMovieList.find { it.movieId == id } ?: MoviesModel()
                  DetailedMovieScreen(movie = movie, backNav = {
                      navController.navigateUp()
                  })
              }
            //  composable("movielistscreen/title={title}/movieList={movieList}",
              composable("movielistscreen/title={title}",
                  arguments = listOf(
                      navArgument("title"){
                           type = NavType.StringType
                          nullable = false
                          defaultValue = ""
                      },
                     // navArgument("movieList") { type = NavType.StringType }
                  ) ){
                  backStack ->
                  val arg = requireNotNull(backStack.arguments)
                  val title = arg.getString("title")?:""
//                  val moviesJson = backStack.arguments?.getString("movieList")
//                  val movieList = moviesJson?.toMovieModelList() ?: listOf()
                  val movieList = if(title == "Favourite"){
                      ApplicationData.favouriteMovieList
                  }else{
                      ApplicationData.animationMovieList
                  }
                  MovieListScreen(backNav = {
                      navController.navigateUp()
                  }, title = title,
                      movieList = movieList,
                      cardClick = {
                      navController.navigate("detail/movie=$it")
                  } )
              }
    }
}
