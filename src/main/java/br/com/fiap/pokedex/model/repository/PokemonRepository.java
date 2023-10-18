package br.com.fiap.pokedex.model.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.fiap.pokedex.model.entity.Pokemon;

public class PokemonRepository {
	
	public static ArrayList<Pokemon> findAll(){
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		Pokemon pokemon1 = new Pokemon(22L, "Pikachu", 0.4, 6.0, "Elétrico", LocalDate.now());
		
		Pokemon pokemon2 = new Pokemon(06L, "Charizard", 1.7, 90.5, "Fogo", LocalDate.now());
		pokemons.add(pokemon1);
		pokemons.add(pokemon2);
		return pokemons;
	}
}
