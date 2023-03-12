package com.mahiiru.pokeinfo.domain.model

data class PokemonDetails(
    val id : Int,
    val name : String,
    val sprite : String,
    val height : Double,
    val weight : Double,
    val types : List<String>,
    val stats : List<PokemonStats>
)
