package com.mahiiru.pokeinfo.data.remote.dto

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)