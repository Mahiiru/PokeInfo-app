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
            if (it.isLoading) Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
            if (it.pokemon != null) {
                with(it.pokemon) {

                }

            }
            if (it.error.isNotEmpty()) Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
        }
        viewModel.getPokemonDetails(id)
    }
}