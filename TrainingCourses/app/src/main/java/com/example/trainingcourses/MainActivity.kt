package com.example.trainingcourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingcourses.data.DataSource
import com.example.trainingcourses.data.Topic
import com.example.trainingcourses.ui.theme.TrainingCoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingCoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic : Topic, modifier : Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.ImageResourceId),
                contentDescription = stringResource(id = topic.StringResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
            )

            Column {
                Text(
                    text= stringResource(id = topic.StringResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(start=16.dp, bottom = 8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start=16.dp, end=8.dp)
                    )

                    Text(
                        text = topic.number.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun TopicGrid(topicsList : List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(count=topicsList.size) {
                TopicCard(
                    topic = topicsList[it],
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    )
}

@Preview
@Composable
fun TopicApp() {
    TopicGrid(topicsList = DataSource.loadTopics())
}