package com.mahiiru.pokeinfo.presentation.pokemon_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahiiru.pokeinfo.common.Resource
import com.mahiiru.pokeinfo.domain.use_case.GetPokemonDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(

    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase

) : ViewModel(){

    private val _state: MutableLiveData<PokemonDetailsState> = MutableLiveData(PokemonDetailsState())
    val state: LiveData<PokemonDetailsState> = _state

     fun getPokemonDetails(pokemonId : Int) {

        getPokemonDetailsUseCase(pokemonId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonDetailsState(pokemon = result.data)
                }
                is Resource.Error -> {
                    _state.value = PokemonDetailsState(error = "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = PokemonDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }
}