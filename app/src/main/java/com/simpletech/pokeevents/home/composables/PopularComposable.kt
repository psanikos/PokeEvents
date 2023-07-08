package com.simpletech.pokeevents.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.simpletech.pokeevents.R
import com.simpletech.pokeevents.models.PokemonModel
import com.simpletech.pokeevents.ui.theme.KBodyRegular
import com.simpletech.pokeevents.ui.theme.KButton
import com.simpletech.pokeevents.ui.theme.KMediumTitle
import com.simpletech.pokeevents.ui.theme.PokeEventsTheme

@Composable
fun PopularComposable(pokemons: List<PokemonModel>) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.popular_pokemon),
            style = MaterialTheme.typography.KMediumTitle
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(196.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(pokemons) {
                PopularPokemonComposable(pokemon = it)
            }
        }
    }
}

@Composable
private fun PopularPokemonComposable(pokemon: PokemonModel) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(138.dp)
            .height(196.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = 4.dp)
            )
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(shape = RoundedCornerShape(35.dp))
                .background(color = MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(pokemon.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = null,
                contentDescription = "${pokemon.name} image)",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(80.dp)
            )
        }
        Box(
            modifier = Modifier
                .width(106.dp)
                .height(36.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.KBodyRegular,
            )
        }
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(106.dp)
                .height(32.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(size = 4.dp)
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 4.dp
                ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = stringResource(id = R.string.connect),
                style = MaterialTheme.typography.KButton,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun PopularPokemonComposablePreview() {
    PokeEventsTheme {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(color = Color(0xFF161616))
        ) {
            PopularComposable(pokemons = PokemonModel.previewItems)
        }
    }
}