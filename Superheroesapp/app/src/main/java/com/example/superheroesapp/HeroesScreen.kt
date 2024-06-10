package com.example.superheroesapp

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroesapp.data.DataSource
import com.example.superheroesapp.models.Hero
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
         defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(all = dimensionResource(id = R.dimen.padding_medium))
        ) {
                HeroInformation(
                    heroName = hero.nameRes,
                    heroDescription = hero.descriptionRes,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = dimensionResource(id = R.dimen.padding_medium))
                )

                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .clip(MaterialTheme.shapes.small),
                    contentScale = ContentScale.Crop
                )
        }
    }
}

@Composable
fun HeroInformation(
    @StringRes heroName : Int,
    @StringRes heroDescription : Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = heroName),
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            text = stringResource(id = heroDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroList(
    heroes : List<Hero>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(heroes) {
            HeroCard(
                hero = it,
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_small)
                    )
            )
        }
    }
}

@Preview
@Composable
fun HeroCardPreview() {
    SuperheroesAppTheme {
        HeroCard(
            hero =  Hero(
                nameRes = R.string.hero4,
                descriptionRes = R.string.description4,
                imageRes = R.drawable.android_superhero4
            )
        )
    }
}

@Preview
@Composable
fun HeroListPreview() {
    val heroes = DataSource.loadHeroes()

    SuperheroesAppTheme {
        HeroList(heroes = heroes)
    }
}

@Preview
@Composable
fun HeroListDarkThemePreview() {
    val heroes = DataSource.loadHeroes()

    SuperheroesAppTheme(
        darkTheme = true
    ) {
        HeroList(heroes = heroes)
    }
}