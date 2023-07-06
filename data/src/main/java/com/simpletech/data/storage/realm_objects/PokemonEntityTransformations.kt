package com.simpletech.data.storage.realm_objects

import com.simpletech.data.dto.OfficialArtworkDTO
import com.simpletech.data.dto.OtherDTO
import com.simpletech.data.dto.PokemonDTO
import com.simpletech.data.dto.SpritesDTO

fun PokemonDTO.toRealmEntity(): PokemonRealmEntity {
    val pokemonRealmEntity = PokemonRealmEntity()
    pokemonRealmEntity.height = height
    pokemonRealmEntity.id = id
    pokemonRealmEntity.name = name
    pokemonRealmEntity.order = order
    pokemonRealmEntity.weight = weight
    pokemonRealmEntity.sprites = sprites?.toRealmEntity()
    return pokemonRealmEntity
}

fun SpritesDTO?.toRealmEntity(): SpritesRealmEntity? {
    if (this == null) return null
    val spritesRealmEntity = SpritesRealmEntity()
    spritesRealmEntity.frontDefault = frontDefault
    spritesRealmEntity.other = other?.toRealmEntity()
    return spritesRealmEntity
}

fun OtherDTO?.toRealmEntity(): OtherRealmEntity? {
    if (this == null) return null
    val otherRealmEntity = OtherRealmEntity()
    otherRealmEntity.officialArtwork = officialArtwork?.toRealmEntity()
    return otherRealmEntity
}

fun OfficialArtworkDTO?.toRealmEntity(): OfficialArtworkRealmEntity? {
    if (this == null) return null
    val officialArtworkRealmEntity = OfficialArtworkRealmEntity()
    officialArtworkRealmEntity.frontDefault = frontDefault
    return officialArtworkRealmEntity
}

fun PokemonRealmEntity.toDTO(): PokemonDTO {
    return PokemonDTO(
        height = height,
        id = id,
        name = name,
        order = order,
        sprites = sprites?.toDTO(),
        weight = weight
    )
}

fun SpritesRealmEntity?.toDTO(): SpritesDTO? {
    if (this == null) return null
    return SpritesDTO(
        frontDefault = frontDefault,
        other = other?.toDTO()
    )
}

fun OtherRealmEntity?.toDTO(): OtherDTO? {
    if (this == null) return null
    return OtherDTO(
        officialArtwork = officialArtwork?.toDTO()
    )
}

fun OfficialArtworkRealmEntity?.toDTO(): OfficialArtworkDTO? {
    if (this == null) return null
    return OfficialArtworkDTO(
        frontDefault = frontDefault
    )
}
