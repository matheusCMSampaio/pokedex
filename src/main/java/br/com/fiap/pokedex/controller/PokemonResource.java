package br.com.fiap.pokedex.controller;

import java.util.ArrayList;

import br.com.fiap.pokedex.model.entity.Pokemon;
import br.com.fiap.pokedex.model.repository.PokemonRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/pokedex")
public class PokemonResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Pokemon> resposta = PokemonRepository.findAll();
		
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Pokemon pokemon) {
		Pokemon resposta = PokemonRepository.save(pokemon);
		
		ResponseBuilder response = null;
		
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		return response.build();
	}
}
