package com.simpletech.domain.repositories

import com.simpletech.domain.models.PokemonDAO
import com.simpletech.domain.utils.NetworkResponseResult

interface PokeRepository {
    suspend fun getFeaturedEvent()
    suspend fun getWeekEvents()
    suspend fun getPokemonByNumber(no: Int): NetworkResponseResult<PokemonDAO>
}