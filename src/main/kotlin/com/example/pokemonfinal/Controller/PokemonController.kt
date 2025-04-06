package com.example.pokemonfinal.Controller

import com.example.pokemonfinal.Model.Pokemon
import com.example.pokemonfinal.service.PokemonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pokemon")
class PokemonController(private val service: PokemonService) {

    @GetMapping
    fun listAllPokemons(): List<Pokemon> = service.getAllPokemons()

    @GetMapping("/{id}")
    fun getPokemonById(@PathVariable id: Int): ResponseEntity<Pokemon> {
        val pokemon = service.getPokemonById(id)
        return if (pokemon != null) ResponseEntity.ok(pokemon)
        else ResponseEntity.notFound().build()
    }
}