package com.mahiiru.pokeinfo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.mahiiru.pokeinfo.R
import com.mahiiru.pokeinfo.databinding.ActivityMainBinding
import com.mahiiru.pokeinfo.presentation.pokemon_list.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : PokemonListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this as LifecycleOwner) {
            if (it.isLoading) Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
            //if (it.coins.isNullOrEmpty().not()) { with(binding.rvPokemons) { adapter = PokemonListAdapter(it.coins)layoutManager = LinearLayoutManager(this) } }
            if (it.error.isNotEmpty()) Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()

        }
    }
}