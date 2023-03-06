package com.mahiiru.pokeinfo.data.repository

import com.mahiiru.pokeinfo.data.remote.PokeApi
import com.mahiiru.pokeinfo.data.remote.dto.toPokemon
import com.mahiiru.pokeinfo.domain.model.Pokemon
import com.mahiiru.pokeinfo.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApi
) : PokemonRepository {


    override suspend fun getPokemons(): List<Pokemon> = api.getPokemonsDTO().results.map { it.toPokemon() }
}