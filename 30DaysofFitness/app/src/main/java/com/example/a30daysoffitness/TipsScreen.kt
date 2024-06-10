package com.example.a30daysoffitness


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysoffitness.data.TipsRepo
import com.example.a30daysoffitness.models.Tip
import com.example.a30daysoffitness.ui.theme.A30DaysOfFitnessTheme

@Composable
fun TipInfo(
    day : String,
    workoutRes : Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.day, day),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.padding_medium))
        )

        Text(
            text = stringResource(id = workoutRes),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun TipDescription(
    descriptionRes: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = descriptionRes),
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Composable
fun TipCard(
    tip: Tip,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        modifier = modifier
            .clickable(
                onClick = onClick
            )
    ) {
        Row(
            modifier = Modifier
        ) {
            TipInfo(
                day = tip.day.toString(),
                workoutRes = tip.workoutRes,
                modifier = Modifier
                    .weight(1f)
                    .padding(all = dimensionResource(id = R.dimen.padding_small))
            )

            Image(
                painter = painterResource(id = tip.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size_small))
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun TipCardExtended(
    tip: Tip,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            TipInfo(
                day = tip.day.toString(),
                workoutRes = tip.workoutRes
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = onClick
            ) {
               Icon(
                   imageVector = Icons.Filled.ExpandLess,
                   contentDescription = null
               )
            }
        }

        Image(
            painter = painterResource(id = tip.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
            contentScale = ContentScale.Crop
        )

        TipDescription(
            descriptionRes = tip.workoutDescriptionRes,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        )
    }
}

@Composable
fun TipItem(
    tip: Tip,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf( false )
    }

    if (!expanded) {
        TipCard(
            tip = tip,
            onClick = { expanded = !expanded },
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium),
                    vertical = dimensionResource(id = R.dimen.padding_small)
                )
        )
    }

    else {
        TipCardExtended(
            tip = tip,
            onClick = { expanded = !expanded },
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium),
                    vertical = dimensionResource(id = R.dimen.padding_small)
                )
        )
    }
}

@Composable
fun TipsList(
    tips : List<Tip>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(tips) {
           TipItem(tip = it)
        }
    }
}


@Preview
@Composable
fun TipsPreview() {
    A30DaysOfFitnessTheme {
        Surface (
            color = MaterialTheme.colorScheme.background
        ) {
            TipsList(tips = TipsRepo.tips)
        }
    }
}

@Preview
@Composable
fun TipsDarkThemePreview() {
    A30DaysOfFitnessTheme(darkTheme = true) {
        Surface (
            color = MaterialTheme.colorScheme.background
        ) {
            TipsList(tips = TipsRepo.tips)
        }
    }
}