package com.mahiiru.pokeinfo.presentation.pokemon_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.mahiiru.pokeinfo.R
import com.mahiiru.pokeinfo.common.Constants.EXTRA_ID
import com.mahiiru.pokeinfo.databinding.ActivityPokemonDetailsBinding
import com.mahiiru.pokeinfo.presentation.pokemon_list.PokemonListViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailsBinding
    private val viewModel : PokemonDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()

        getPokemonDetails(id.toInt())
    }

    private fun getPokemonDetails(id: Int) {
        viewModel.state.observe(this as LifecycleOwner) {
            if (it.isLoading) Toast.makeText(this, "loading $id", Toast.LENGTH_SHORT).show()
            if (it.pokemon != null) {
                with(it.pokemon) {
                    Picasso.get().load(it.pokemon.sprite).into(binding.ivPokemonDetailsSprite)
                    binding.tvPokemonDetailsWeight.text = "Weight = ${it.pokemon.weight}"
                    binding.tvPokemonDetailsHeight.text = "Height = ${it.pokemon.height}"
                    it.pokemon.stats.forEach { stat ->
                        when(stat.name){
                            "hp" -> binding.tvHP.text = "HP = ${stat.baseStat}"
                            "attack" -> binding.tvATK.text = "ATK = ${stat.baseStat}"
                            "defense" -> binding.tvDEF.text = "DEF = ${stat.baseStat}"
                            "special-attack" -> binding.tvSATK.text = "SATK = ${stat.baseStat}"
                            "special-defense" -> binding.tvSDEF.text = "SDEF = ${stat.baseStat}"
                            "speed" -> binding.tvSPD.text = "SPD = ${stat.baseStat}"
                        }
                    }
                }

            }
            if (it.error.isNotEmpty()) Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
        }
        viewModel.getPokemonDetails(id)
    }
}