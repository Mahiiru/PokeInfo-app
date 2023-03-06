package com.mahiiru.pokeinfo.presentation.pokemon_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahiiru.pokeinfo.databinding.ItemPokemonListBinding
import com.mahiiru.pokeinfo.domain.model.Pokemon
import com.squareup.picasso.Picasso

class PokemonListViewHolder(itemView : View)
    : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemPokemonListBinding.bind(itemView)

    fun bind(pokemon : Pokemon){
        Picasso.get().load(pokemon.sprite).into(binding.ivPokemonList)
        binding.tvPokemonListID.text = pokemon.id.toString()
        binding.tvPokemonListName.text = pokemon.name.replaceFirstChar { it.uppercaseChar() }
    }
}