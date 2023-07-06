package com.simpletech.domain.use_cases.use_case_services

import com.simpletech.domain.models.PokemonDAO

interface FetchPopularPokemonUseCase {
    suspend fun execute(): List<PokemonDAO>
}