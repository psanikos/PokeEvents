package com.simpletech.domain.repositories

import com.simpletech.domain.models.PokemonDAO

interface PokeRepository {
    suspend fun getFeaturedEvent()
    suspend fun getWeekEvents()
    suspend fun getPopularPokemon(): List<PokemonDAO>
}