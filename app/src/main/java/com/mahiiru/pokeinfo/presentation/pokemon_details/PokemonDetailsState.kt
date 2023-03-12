package com.mahiiru.pokeinfo.presentation.pokemon_details

import com.mahiiru.pokeinfo.domain.model.Pokemon
import com.mahiiru.pokeinfo.domain.model.PokemonDetails

data class PokemonDetailsState(
    val isLoading : Boolean = false,
    val pokemon : PokemonDetails? = null,
    val error : String = ""
)
