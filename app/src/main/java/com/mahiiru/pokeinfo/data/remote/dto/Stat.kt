package com.mahiiru.pokeinfo.data.remote.dto

import com.mahiiru.pokeinfo.domain.model.PokemonStats

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatX
)

fun Stat.toPokemonStats() : PokemonStats = PokemonStats(
    baseStat = base_stat,
    name = stat.name
)