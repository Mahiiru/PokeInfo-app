package com.mahiiru.pokeinfo.presentation.pokemon_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahiiru.pokeinfo.common.Resource
import com.mahiiru.pokeinfo.domain.use_case.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class PokemonListViewModel @Inject constructor(

    private val getPokemonsUseCase: GetPokemonsUseCase

) : ViewModel() {


    private val _state: MutableLiveData<PokemonListState> = MutableLiveData(PokemonListState())
    val state: LiveData<PokemonListState> = _state

    init {
        getPokemons()
    }

    private fun getPokemons() {

        getPokemonsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonListState(pokemons = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PokemonListState(error = "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = PokemonListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}