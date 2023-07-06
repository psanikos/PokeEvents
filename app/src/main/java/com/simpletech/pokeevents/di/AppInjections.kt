package com.simpletech.pokeevents.di

import com.simpletech.pokeevents.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appInjections = module {
    viewModel<HomeViewModel> { HomeViewModel(get()) }
}