//package com.example.pokemonfinal.Controller
//
//import com.example.pokemonfinal.service.PokemonService
//import com.example.pokemonfinal.Model.Pokemon
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers
//
//@WebMvcTest(PokemonController::class)  // Tells Spring to only load the Controller and Web Layer for testing
//class PokemonControllerTest {
//
//    @Autowired
//    lateinit var mockMvc: MockMvc  // MockMvc is used to simulate HTTP requests
//
//    @Mock
//    lateinit var pokemonService: PokemonService  // Mock the service
//
//    @BeforeEach
//    fun setUp() {
//        MockitoAnnotations.openMocks(this)  // Initialize mocks before each test
//    }
//
//    @Test
//    fun `should return list of all pokemons`() {
//        // Given: A mocked list of pokemons
//        val pokemonList = listOf(
//            Pokemon(1, "Bulbasaur", listOf("Grass", "Poison"), 1, "https://img.pokemondb.net/artwork/large/bulbasaur.jpg"),
//            Pokemon(2, "Ivysaur", listOf("Grass", "Poison"), 2, "https://img.pokemondb.net/artwork/large/ivysaur.jpg")
//        )
//
//        // When: The service's getAllPokemons method is mocked to return the list
//        Mockito.`when`(pokemonService.getAllPokemons()).thenReturn(pokemonList)
//
//        // Then: Send a GET request to /api/pokemon and expect a 200 OK status with the JSON list of pokemons
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/pokemon")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))  // Check that the first pokemon id is 1
//            .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Bulbasaur"))  // Check that the name is correct
//            .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Ivysaur"))  // Check that the second pokemon name is correct
//    }
//
//    @Test
//    fun `should return pokemon by id when found`() {
//        // Given: A mocked pokemon
//        val pokemon = Pokemon(1, "Bulbasaur", listOf("Grass", "Poison"), 1, "https://img.pokemondb.net/artwork/large/bulbasaur.jpg")
//
//        // When: The service's getPokemonById is mocked to return the pokemon
//        Mockito.`when`(pokemonService.getPokemonById(1)).thenReturn(pokemon)
//
//        // Then: Send a GET request to /api/pokemon/1 and expect a 200 OK status with the pokemon details in JSON
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/pokemon/1")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))  // Check that the pokemon id is 1
//            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bulbasaur"))  // Check that the name is correct
//    }
//
//    @Test
//    fun `should return 404 not found when pokemon by id is not found`() {
//        // When: The service's getPokemonById is mocked to return null for an id that doesn't exist
//        Mockito.`when`(pokemonService.getPokemonById(99)).thenReturn(null)
//
//        // Then: Send a GET request to /api/pokemon/99 and expect a 404 Not Found response
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/pokemon/99")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(MockMvcResultMatchers.status().isNotFound)
//    }
//}
