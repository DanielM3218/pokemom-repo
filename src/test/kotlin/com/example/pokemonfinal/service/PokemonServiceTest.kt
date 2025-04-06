package com.example.pokemonfinal.service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class PokemonServiceTest {

    // ניצור אובייקט של PokemonService
    private val pokemonService = PokemonService()

    @Test
    fun `should return all pokemons`() {
        // נקרא לפונקציה getAllPokemons
        val result = pokemonService.getAllPokemons()

        // נוודא שהרשימה לא ריקה וכוללת את הפוקימונים הצפויים
        assertThat(result).isNotEmpty
        assertThat(result).hasSize(2)  // מאחר ויש לנו בדיוק שני פוקימונים ברשימה

        // נוודא שהפרטים של הפוקימונים נכונים
        assertThat(result[0].name).isEqualTo("Bulbasaur")
        assertThat(result[1].name).isEqualTo("Ivysaur")
    }

    @Test
    fun `should return pokemon by id`() {
        // נקרא לפונקציה getPokemonById עם id 1
        val result = pokemonService.getPokemonById(1)

        // נוודא שהפוקימון שהתקבל הוא Bulbasaur
        assertThat(result).isNotNull
        assertThat(result?.name).isEqualTo("Bulbasaur")

        // נקרא לפונקציה getPokemonById עם id לא קיים
        val nonExistentPokemon = pokemonService.getPokemonById(999)

        // נוודא שהפוקימון לא נמצא ושהוא null
        assertThat(nonExistentPokemon).isNull()
    }
}
