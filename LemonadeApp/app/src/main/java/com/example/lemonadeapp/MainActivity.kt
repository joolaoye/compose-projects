package com.example.lemonadeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun ImageWithText(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf(1)}
    var clicks by remember { mutableStateOf(0)}
    var randomNumber by remember { mutableStateOf((2..4).random())}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.Green,
            modifier = Modifier
                .padding(bottom=16.dp)
        ) {
            Image(
                painter = painterResource(
                    id = when(number) {
                        1 -> R.drawable.lemon_tree
                        2 -> R.drawable.lemon_squeeze
                        3 -> R.drawable.lemon_drink
                        else -> R.drawable.lemon_restart
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        when (number) {
                            2 -> {
                                clicks += 1
                                if (clicks == randomNumber) {
                                    number = (number + 1) % 4
                                    clicks = 0
                                    randomNumber = (2..4).random()
                                }
                            }

                            else -> number = (number + 1) % 4
                        }
                    }
            )
        }
        Text(
            text = when(number) {
                1 -> "Tap the lemon tree to select a lemon"
                2 -> "Keep tapping the lemon to squeeze it"
                3 -> "Tap the lemonade to drink it"
                else -> "Tap the empty glass to start again"
            })
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Scaffold(
        topBar =
        {
            TopAppBar(
                backgroundColor = Color.Yellow
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.lemonade),
                        fontWeight = Bold,
                        fontSize=24.sp
                    )
                }
            }
        }
    ) {paddingValues ->
        ImageWithText(modifier = Modifier.padding(paddingValues))
    }
}