package com.mahiiru.pokeinfo.presentation.pokemon_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahiiru.pokeinfo.R
import com.mahiiru.pokeinfo.domain.model.Pokemon

class PokemonListAdapter(
    private val pokemons : List<Pokemon>,
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<PokemonListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder = PokemonListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_list,parent,false)
    )

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokemons[position],onItemSelected)
    }
}