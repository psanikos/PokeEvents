package com.simpletech.domain.use_cases

import com.simpletech.domain.models.PokemonDAO
import com.simpletech.domain.repositories.PokeRepository
import com.simpletech.domain.use_cases.use_case_services.FetchPopularPokemonUseCase
import com.simpletech.domain.utils.NetworkResponseResult
import kotlin.random.Random

class FetchPopularPokemonUseCaseImpl(
    private val repo: PokeRepository
): FetchPopularPokemonUseCase {
    override suspend fun execute(): List<PokemonDAO> {
      return repo.getPopularPokemon()
    }
}