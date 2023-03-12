package com.mahiiru.pokeinfo.presentation.pokemon_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahiiru.pokeinfo.R
import com.mahiiru.pokeinfo.common.Constants.EXTRA_ID
import com.mahiiru.pokeinfo.databinding.ActivityPokemonDetailsBinding

class PokemonDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()

        getPokemonDetails(id)
    }

    private fun getPokemonDetails(id: String) {
        TODO("Not yet implemented")
    }
}