package com.mahiiru.pokeinfo.data.remote.dto

import com.mahiiru.pokeinfo.domain.model.Pokemon

data class PokemonDTO(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)