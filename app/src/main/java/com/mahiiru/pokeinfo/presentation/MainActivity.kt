package com.mahiiru.pokeinfo.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahiiru.pokeinfo.R
import com.mahiiru.pokeinfo.common.Constants.EXTRA_ID
import com.mahiiru.pokeinfo.databinding.ActivityMainBinding
import com.mahiiru.pokeinfo.presentation.pokemon_details.PokemonDetailsActivity
import com.mahiiru.pokeinfo.presentation.pokemon_list.PokemonListAdapter
import com.mahiiru.pokeinfo.presentation.pokemon_list.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonListAdapter: PokemonListAdapter
    private val viewModel : PokemonListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this as LifecycleOwner) {
            if (it.isLoading) Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
            if (it.pokemons.isNullOrEmpty().not()) {
                pokemonListAdapter = PokemonListAdapter(it.pokemons)
                binding.rvPokemons.layoutManager = LinearLayoutManager(this)
                binding.rvPokemons.adapter = pokemonListAdapter

            }
            if (it.error.isNotEmpty()) Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()

        }
    }

    private fun navigateToPokemonDetails(id: String) {
        val intent = Intent(this, PokemonDetailsActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }


}