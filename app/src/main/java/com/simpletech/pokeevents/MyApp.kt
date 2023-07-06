package com.simpletech.pokeevents

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.simpletech.pokeevents.home.HomeView
import com.simpletech.pokeevents.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyApp() {
    val homeViewModel = koinViewModel<HomeViewModel>()

    HomeView(homeViewModel)
}