package com.mahiiru.pokeinfo.domain.repository

import com.mahiiru.pokeinfo.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemons() : List<Pokemon>
}