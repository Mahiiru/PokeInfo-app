package com.mahiiru.pokeinfo.domain.use_case

import com.mahiiru.pokeinfo.common.Resource
import com.mahiiru.pokeinfo.domain.model.PokemonDetails
import com.mahiiru.pokeinfo.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(pokemonId: Int): Flow<Resource<PokemonDetails>> = flow<Resource<PokemonDetails>>  {
        try {
            emit(Resource.Loading())
            val pokemonDetails = repository.getPokemonDetails(pokemonId)
            emit(Resource.Success(pokemonDetails))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Connection to server error"))
        }
    }
}