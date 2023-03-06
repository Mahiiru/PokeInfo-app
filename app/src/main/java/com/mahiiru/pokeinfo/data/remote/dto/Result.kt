package com.mahiiru.pokeinfo.data.remote.dto

import com.mahiiru.pokeinfo.common.Constants.SPRITE_END_URL
import com.mahiiru.pokeinfo.common.Constants.SPRITE_START_URL
import com.mahiiru.pokeinfo.domain.model.Pokemon

data class Result(
    val name: String,
    val url: String
)

fun Result.toPokemon() : Pokemon {
    val idResult = url.split("/").filter { it.isNotEmpty() }.last()
    return Pokemon(
        id = idResult.toInt(),
        name = name,
        sprite = SPRITE_START_URL + idResult + SPRITE_END_URL
    )
}