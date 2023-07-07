package com.simpletech.pokeevents.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.simpletech.pokeevents.home.composables.FeaturedEvent
import com.simpletech.pokeevents.home.composables.PopularComposable
import com.simpletech.pokeevents.models.toPresentationModels

@Composable
fun HomeView(
    controller: NavHostController,
    viewModel: HomeViewModel
) {
    val popularPokemon by viewModel.popularPokemon.collectAsStateWithLifecycle(listOf())
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            FeaturedEvent()
        }
        item {
            PopularComposable(pokemons = popularPokemon.toPresentationModels())
        }
    }
}