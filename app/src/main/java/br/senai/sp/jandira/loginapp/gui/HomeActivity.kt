package br.senai.sp.jandira.loginapp.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.loginapp.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.gui.ui.theme.LOGINAppTheme
import br.senai.sp.jandira.loginapp.model.Category
import br.senai.sp.jandira.loginapp.model.Trip
import br.senai.sp.jandira.loginapp.repository.CategoryRepository
import br.senai.sp.jandira.loginapp.repository.TripRepository

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // pegar id
        intent.extras
        Log.i(
            "ds2m",
            "id ")

        setContent {
            LOGINAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(CategoryRepository.getCategories(),
                        TripRepository.getTrips()) //retorna uma lista de categorias
                }
            }
        }
    }
}

@Composable
fun HomeScreen(categories: List<Category>, trips: List<Trip>) { //ele precisa da lista de categorias

    TripRepository.getTrips()

    //inicio column principal
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
            shape = RectangleShape
    ) {
        Image(
            painter = painterResource(id = R.drawable.paris),
            contentDescription = "logo",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }

        Text(
            text = stringResource(id = R.string.categories),
            color = Color(56, 54, 54),
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

        LazyRow(){
            items(categories){
                Card(
                    modifier = Modifier
                        .size(width = 120.dp, height = 100.dp)
                        .padding(vertical = 8.dp, horizontal = 4.dp),
                    backgroundColor = Color(207, 6, 240)
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = it.categoryIcon,
                            contentDescription = it.categoryName
                        )

                        Text(text = it.categoryName,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.search))
            },
            trailingIcon = { //colocar o icon no fim do outlined
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }
        )
        Text(
            text = stringResource(id = R.string.past_trips),
            fontSize = 14.sp,
            color = Color(86, 84, 84),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        LazyColumn(){
            items(trips){
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.no_photography_24),
                            contentDescription = "")
                        Text(text = "${it.location}, ${it.startDate.year}")
                        Text(text = "${it.description}")
                        Text(
                            text = "${it.startDate} - ${it.endDate}",
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LOGINAppTheme {
        HomeScreen(
            CategoryRepository.getCategories(),
            TripRepository.getTrips()
        )
    }
}