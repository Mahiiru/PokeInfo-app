package com.mahiiru.pokeinfo.data.remote

import com.mahiiru.pokeinfo.data.remote.dto.PokemonDTO
import com.mahiiru.pokeinfo.data.remote.dto.PokemonDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET("pokemon?limit=1008")
    suspend fun getPokemonsDTO() : PokemonDTO

    @GET("pokemon/{pokemonId}/")
    suspend fun getPokemonDetailsDTOById(@Path("pokemonId") pokemonId: Int) : PokemonDetailsDTO

}