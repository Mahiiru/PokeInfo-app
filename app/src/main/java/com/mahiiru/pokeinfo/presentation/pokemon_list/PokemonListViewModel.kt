package com.mahiiru.pokeinfo.presentation.pokemon_list

import androidx.lifecycle.ViewModel
import com.mahiiru.pokeinfo.domain.use_case.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonListViewModel @Inject constructor(

    private val getPokemonsUseCase: GetPokemonsUseCase

) : ViewModel() {


}