package com.simpletech.pokeevents.models

import com.simpletech.data.base.thisOrEmpty
import com.simpletech.domain.models.PokemonDAO


data class PokemonModel(
    val id: Long,
    val name: String,
    val imageUrl: String
) {
    companion object {
        @JvmStatic
        val previewItems: List<PokemonModel>
            get() = listOf(
                PokemonModel(
                    id = 1L,
                    name = "Bulbasaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
                ),
                PokemonModel(
                    id = 2L,
                    name = "Pikachu",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"
                ),
                PokemonModel(
                    id = 3L,
                    name = "Charmander",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"
                )
            )

        @JvmStatic
        val previewItem = PokemonModel(
            id = 1L,
            name = "Bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
        )
    }
}

typealias PokemonDAOS = List<PokemonDAO>

fun PokemonDAOS.toPresentationModels() = this.map { it.toPresentationModel() }

fun PokemonDAO.toPresentationModel(): PokemonModel {
    return PokemonModel(
        id = this.id.thisOrEmpty(),
        name = name.thisOrEmpty().capitalize(),
        imageUrl = frontDefaultArtWork.thisOrEmpty()
    )
}

typealias Pokemons = List<PokemonModel>