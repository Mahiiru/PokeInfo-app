package com.mahiiru.pokeinfo.domain.use_case

import com.mahiiru.pokeinfo.common.Resource
import com.mahiiru.pokeinfo.domain.model.Pokemon
import com.mahiiru.pokeinfo.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke () : Flow<Resource<List<Pokemon>>> = flow{
        try {
            emit(Resource.Loading<List<Pokemon>>())
            val pokemons = repository.getPokemons()
            emit(Resource.Success<List<Pokemon>>(pokemons))
        }catch (e : HttpException){
            emit(Resource.Error<List<Pokemon>>(e.localizedMessage ?: "An unexpected error occurred."))
        }catch (e : IOException){
            emit(Resource.Error<List<Pokemon>>("Couldn't reach server. Check your internet connection."))
        }
    }
}