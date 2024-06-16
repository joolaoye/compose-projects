package com.example.lemonadeapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lemonadeapp.R

@Composable
fun ImageWithText(
    image : Int,
    description : Int,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            color = Color.Green,
            modifier = Modifier
                .padding(bottom= dimensionResource(id = R.dimen.padding_medium))
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .clickable { onClick() }
            )
        }
        Text(text = stringResource(id = description))
    }
}

@Composable
fun LemonadeApp(
    lemonadeAppViewModel: LemonadeAppViewModel = viewModel()
) {
    val lemonadeAppUiState by lemonadeAppViewModel.uiState.collectAsState()

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
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
        }
    ) {paddingValues ->
        ImageWithText(
            image = lemonadeAppUiState.image,
            description = lemonadeAppUiState.description,
            onClick = { lemonadeAppViewModel.updateCount() },
            modifier = Modifier.padding(paddingValues)
        )
    }
}