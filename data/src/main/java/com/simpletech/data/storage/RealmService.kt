package com.simpletech.data.storage

import com.simpletech.data.dto.PokemonDTO
import com.simpletech.data.storage.realm_objects.OfficialArtworkRealmEntity
import com.simpletech.data.storage.realm_objects.OtherRealmEntity
import com.simpletech.data.storage.realm_objects.PokemonRealmEntity
import com.simpletech.data.storage.realm_objects.SpritesRealmEntity
import com.simpletech.data.storage.realm_objects.toDTO
import com.simpletech.data.storage.realm_objects.toRealmEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.Sort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RealmService {
    private val pokemonConfig = RealmConfiguration.Builder(
        setOf(
            PokemonRealmEntity::class,
            SpritesRealmEntity::class,
            OfficialArtworkRealmEntity::class,
            OtherRealmEntity::class
        )
    ).build()

    suspend fun savePopularPokemon(pokemon: PokemonDTO) {
        try {
            saveOrReplacePokemon(pokemon)
        } catch (e: Exception) {
        }

    }

    private suspend fun saveOrReplacePokemon(pokemon: PokemonDTO) {
        val entity = pokemon.toRealmEntity()
        val realm = Realm.open(pokemonConfig)
        realm.write { // Keep only 5 in memory
            val objects = realm.query<PokemonRealmEntity>().find()
            if (objects.size >= 5) {
                val target = realm.query<PokemonRealmEntity>()
                    .sort(property = "dateAdded", sortOrder = Sort.ASCENDING)
                    .first()
                target.find()?.let {
                    val liveObject = findLatest(it)
                    // Delete oldest
                    liveObject?.let { obj ->
                        delete(obj)
                    }
                }
            }
            copyToRealm(entity)
        }
        realm.close()
    }

    suspend fun fetchSavedPokemon(): List<PokemonDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val realm = Realm.open(pokemonConfig)
                val pokemons = realm.query<PokemonRealmEntity>().find()
                val result = pokemons.map { it.toDTO() }
                realm.close()
                result
            } catch (e: Exception) {
                listOf<PokemonDTO>()
            }
        }
}
