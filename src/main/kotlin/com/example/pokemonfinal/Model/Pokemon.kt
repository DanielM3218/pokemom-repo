package com.example.pokemonfinal.Model

data class Pokemon(
    val id: Int,               // A unique identifier for each Pokémon
    val name: String,          // The name of the Pokémon (e.g., Bulbasaur)
    val types: List<String>,   // The Pokémon's types (e.g., Grass, Poison)
    val pokedexNumber: Int,    // The Pokédex number of the Pokémon
    val imageUrl: String       // A link to an image of the Pokémon
)