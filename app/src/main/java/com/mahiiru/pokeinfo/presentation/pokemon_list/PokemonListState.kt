package com.mahiiru.pokeinfo.presentation.pokemon_list

import com.mahiiru.pokeinfo.domain.model.Pokemon

data class PokemonListState(
    val isLoading : Boolean = false,
    val pokemons : List<Pokemon> = emptyList(),
    val error : String = ""
)
