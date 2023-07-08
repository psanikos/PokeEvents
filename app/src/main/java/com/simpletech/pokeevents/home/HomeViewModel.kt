package com.simpletech.pokeevents.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simpletech.domain.models.PokemonDAO
import com.simpletech.domain.use_cases.use_case_services.FetchPopularPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fetchPopularPokemonUseCase: FetchPopularPokemonUseCase
) : ViewModel() {

    private val _popularPokemon = MutableStateFlow(listOf<PokemonDAO>())
    val popularPokemon = _popularPokemon.asStateFlow()

    init {
        fetchPopularPokemon()
    }

    private fun fetchPopularPokemon() {
        viewModelScope.launch {
            val response = fetchPopularPokemonUseCase.execute()
            _popularPokemon.emit(response)
        }
    }
}