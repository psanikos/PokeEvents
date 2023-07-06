package com.simpletech.data.services

import android.util.Log
import com.simpletech.data.base.Urls
import com.simpletech.data.dto.PokemonDTO
import com.simpletech.data.dto.toDAO
import com.simpletech.data.storage.RealmService
import com.simpletech.domain.models.PokemonDAO
import com.simpletech.domain.repositories.PokeRepository
import com.simpletech.domain.utils.NetworkResponseResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.timeout
import io.ktor.client.request.get
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlin.random.Random

class PokeRepositoryImpl(
    private val client: HttpClient,
    private val realmService: RealmService
): PokeRepository {
    override suspend fun getFeaturedEvent() {
        TODO("Not yet implemented since pokeApi does not provide this data")
    }

    override suspend fun getWeekEvents() {
        TODO("Not yet implemented since pokeApi does not provide this data")
    }

    override suspend fun getPopularPokemon(): List<PokemonDAO> {
        val output = mutableListOf<PokemonDAO>()
        // Getting 5 random pokemon to show as popular
        val randomNumbers = mutableListOf<Int>()
        repeat(5) { randomNumbers.add(Random.nextInt(1,151))}
        randomNumbers.forEach {
            val response = getPokemonByNumber(it)
            if (response is NetworkResponseResult.Success) {
                output.add(response.data)
            }
        }
        if(output.isEmpty()) {
            val cachedData = realmService.fetchSavedPokemon()
            return  cachedData.map { it.toDAO() }
        }
        return output
    }
    private suspend fun getPokemonByNumber(no: Int): NetworkResponseResult<PokemonDAO> {
        return try {
            val data = client.get {
                method = HttpMethod.Get
                url {
                    protocol = URLProtocol.HTTPS
                    host = Urls.POKE_API_BASE_URL
                    path(Urls.GET_POKEMON_URL + "$no")
                }
            }.body<PokemonDTO>()
            realmService.savePopularPokemon(data)
            NetworkResponseResult.Success(data.toDAO())
        } catch (e: Exception) {
            return  NetworkResponseResult.Failure(e)
        }
    }
}