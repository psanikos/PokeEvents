package com.simpletech.data.dto

import com.simpletech.domain.models.PokemonDAO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO (
    val height: Long? = null,
    val id: Long? = null,
    val name: String? = null,
    val order: Long? = null,
    val sprites: SpritesDTO? = null,
    val weight: Long? = null
)

@Serializable
data class SpritesDTO (
    @SerialName("front_default")
    val frontDefault: String? = null,
    val other: OtherDTO? = null,
)

@Serializable
data class OfficialArtworkDTO (
    @SerialName("front_default")
    val frontDefault: String? = null,
)
@Serializable
data class OtherDTO (
    @SerialName("official-artwork")
    val officialArtwork: OfficialArtworkDTO? = null
)


fun PokemonDTO.toDAO(): PokemonDAO {
    return  PokemonDAO(
        height = height,
        name = name,
        id = id,
        weight = weight,
        frontDefault = sprites?.frontDefault,
        frontDefaultArtWork = sprites?.other?.officialArtwork?.frontDefault
    )
}