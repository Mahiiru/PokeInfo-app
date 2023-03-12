package com.mahiiru.pokeinfo.data.remote.dto

import com.mahiiru.pokeinfo.common.Constants.SPRITE_END_URL
import com.mahiiru.pokeinfo.common.Constants.SPRITE_START_URL
import com.mahiiru.pokeinfo.domain.model.PokemonDetails

data class PokemonDetailsDTO(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

fun PokemonDetailsDTO.toPokemonDetails() : PokemonDetails = PokemonDetails(
    id = id,
    name = name,
    sprite = SPRITE_START_URL + id.toString() + SPRITE_END_URL,
    height = height.toDouble() / 100,
    weight = weight.toDouble() / 100,
    types = types.map { it.type.name },
    stats = stats.map { it.toPokemonStats() }
)