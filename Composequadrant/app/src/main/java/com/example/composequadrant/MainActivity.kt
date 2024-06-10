package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            TextComposable(title ="Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                color = Color(0xFFEADDFF),
                modifier = Modifier
                    .weight(1f)
            )

            TextComposable(title ="Image composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                color = Color(0xFFD0BCFF),
                modifier = Modifier
                    .weight(1f)
            )
        }

        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            TextComposable(title ="Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                color = Color(0xFFB69DF8),
                modifier = Modifier
                    .weight(1f)
            )

            TextComposable(title ="Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                color = Color(0xFFF6EDFF),
                modifier = Modifier
                    .weight(1f)
            )
        }

    }
}

@Composable
fun TextComposable(title : String, description : String, color : Color, modifier: Modifier = Modifier) {

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }

}

@Preview
@Composable
fun PreviewQuadrant() {
    Quadrant()
}
