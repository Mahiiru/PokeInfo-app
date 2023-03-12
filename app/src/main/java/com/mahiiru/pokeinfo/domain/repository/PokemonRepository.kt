package com.mahiiru.pokeinfo.domain.repository

import com.mahiiru.pokeinfo.domain.model.Pokemon
import com.mahiiru.pokeinfo.domain.model.PokemonDetails

interface PokemonRepository {

    suspend fun getPokemons() : List<Pokemon>

    suspend fun getPokemonDetails(pokemonId : Int) : PokemonDetails
}