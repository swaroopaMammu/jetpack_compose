package com.example.mycomposeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mycomposeapp.model.MoviesModel

@Composable
fun HomeScreen(categoryClick : (id:String) -> Unit){
    Scaffold { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            OutlinedCard(onClick = { categoryClick("Animated") }) {
                Text(text = "Animated Movies", modifier = Modifier.padding(10.dp))
            }
            OutlinedCard(onClick = { categoryClick("Favourite") }) {
                Text(text = "Favourite Movies", modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
fun MovieListScreen(title:String,movieList:List<MoviesModel>,backNav: () -> Unit,cardClick:(Int)->Unit){
    Scaffold { padding ->
        Box(
            Modifier
                .padding(padding)
                .fillMaxWidth()
                .background(color = Color.Black) ) {
            Column( horizontalAlignment = Alignment.CenterHorizontally) {
                AppBar(title, modifier = Modifier,backNav)
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn {
                    items(movieList) { item ->
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .clickable {
                                    cardClick(item.movieId)
                                }
                                .width(200.dp)
                                .height(150.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp, bottom = 5.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = item.poster),
                                    contentDescription = "movie poster",
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title:String,modifier: Modifier,backNav:()-> Unit){
     TopAppBar(title = { Text(text = title) },
         modifier = modifier,
         navigationIcon = {
             IconButton(onClick = { backNav()}) {
                 Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "back navigation")
             }
         },
         colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red)
     )
}

@Composable
fun DetailedMovieScreen(movie:MoviesModel,backNav:()-> Unit){
    Scaffold { padding ->
        ConstraintLayout( Modifier.padding(padding).fillMaxSize()) {
            val (appbar,poster,desc) = createRefs()
            AppBar("Movie in Detail",
                modifier = Modifier.constrainAs(appbar){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                backNav
            )
            Image(painter = painterResource(id = movie.poster), contentDescription = "movie image",
                modifier = Modifier.constrainAs(poster){
                    top.linkTo(appbar.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Text(text = movie.description,
                modifier = Modifier.constrainAs(desc){
                    top.linkTo(poster.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    width = Dimension.fillToConstraints
                })
        }


    }
}