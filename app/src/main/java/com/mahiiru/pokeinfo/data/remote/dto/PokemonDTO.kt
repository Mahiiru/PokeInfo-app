package com.mahiiru.pokeinfo.data.remote.dto

data class PokemonDTO(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)