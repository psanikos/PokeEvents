package com.simpletech.domain.use_cases

import com.simpletech.domain.repositories.PokeRepository
import com.simpletech.domain.use_cases.use_case_services.FetchPopularPokemonUseCase

class FetchPopularPokemonUseCaseImpl(
    val repo: PokeRepository
): FetchPopularPokemonUseCase {
    override suspend fun execute() {
        TODO("Not yet implemented")
    }
}