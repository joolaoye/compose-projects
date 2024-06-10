package com.example.a30daysoffitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysoffitness.data.TipsRepo
import com.example.a30daysoffitness.ui.theme.A30DaysOfFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A30DaysOfFitnessTheme {
                FitnessApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string._30_days_of_fitness_plan),
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}

@Composable
fun FitnessApp() {
    Scaffold(
        topBar = { TopBar() },
        modifier = Modifier.fillMaxSize()
    ) {
        val tips = TipsRepo.tips
        TipsList(tips = tips, modifier = Modifier.padding(it))
    }
}

@Preview
@Composable
fun FitnessAppPreview() {
    A30DaysOfFitnessTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            FitnessApp()
        }
    }
}

@Preview
@Composable
fun FitnessAppDarkThemePreview() {
    A30DaysOfFitnessTheme(darkTheme = true) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            FitnessApp()
        }
    }
}