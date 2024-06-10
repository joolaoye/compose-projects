package com.example.artspaceapp

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ImageContainer(image : Int, description : String) {
    Card(
        elevation = 32.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(480.dp)
            .padding(32.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = description,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
        }
    }
}

@Composable
fun DescriptionContainer(name : String, creator : String, yearTaken : String) {
    Box (
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = name,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 4.dp)
            )

            Row() {
                Text(
                    text = creator,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(end = 4.dp)
                )

                Text(
                    text="($yearTaken)"
                )
            }
        }
    }
}

@Composable
fun ButtonContainer(onPrevious : () -> Unit, onNext : () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Button(onClick = onPrevious) {
            Text(text = stringResource(R.string.previous))
        }

        Button(onClick = onNext) {
            Text(text= stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    val arts  = listOf(
        Art(
            Image =  R.drawable.california_bridge,
            Name = "Golden Gate Brigde",
            Creator = "Robert So",
            YearTaken = "2024"
        ),
        Art(
            Image =  R.drawable.grand_canal,
            Name = "Grand Canal in Venice",
            Creator = "Elisa Giaccaglia",
            YearTaken = "2023"
        ),
        Art(
            Image =  R.drawable.empire_state_building,
            Name = "Empire State Building",
            Creator = "Lukas Kloeppel",
            YearTaken = "2017"
        ),
        Art(
            Image =  R.drawable.eiffel_tower,
            Name = "Eiffel Tower",
            Creator = "Flo Dahm",
            YearTaken = "2017"
        ),
        Art(
            Image =  R.drawable.great_sphinx,
            Name = "Great Sphinx of Giza",
            Creator = "Pixabay",
            YearTaken = "2016"
        ),
        Art(
            Image =  R.drawable.taj_mahal,
            Name = "Taj Mahal and the Four Minarets",
            Creator = "Sudipta Mondal",
            YearTaken = "2018"
        ),
        Art(
            Image =  R.drawable.leaning_tower,
            Name = "Leaning Tower of Pisa",
            Creator = "Hitesh Choudhary",
            YearTaken = "2018"
        )

    )

    var pointer by remember { mutableStateOf(0) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .statusBarsPadding()
    ) {
        ImageContainer(image = arts[pointer].Image, description = arts[pointer].Name)
        DescriptionContainer(name = arts[pointer].Name, creator = arts[pointer].Creator, yearTaken = arts[pointer].YearTaken)
        ButtonContainer(
            onPrevious = {pointer = (pointer - 1 + arts.size) % arts.size},
            onNext = {pointer = (pointer + 1) % arts.size}
        )
    }
}