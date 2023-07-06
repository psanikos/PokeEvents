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
        val output = mutableListOf<PokemonDAO>()
        // Getting 5 random pokemon to show as popular
        val randomNumbers = mutableListOf<Int>()
        repeat(5) { randomNumbers.add(Random.nextInt(1,151))}
        randomNumbers.forEach {
            val response = repo.getPokemonByNumber(it)
            if (response is NetworkResponseResult.Success) {
                output.add(response.data)
            }
        }
        return output
    }
}