package br.com.fiap.pokedex.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.fiap.pokedex.model.entity.Pokemon;

public class PokemonRepository extends Repository {

	public static ArrayList<Pokemon> findAll() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		String sql = "select * from tb_pokemons";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Pokemon pokemon = new Pokemon();
					pokemon.setNumero(rs.getLong("numero"));
					pokemon.setNome(rs.getString("nome"));
					pokemon.setAltura(rs.getDouble("altura"));
					pokemon.setPeso(rs.getDouble("peso"));
					pokemon.setCategoria(rs.getString("categoria"));
					pokemon.setDataDaCaptura(rs.getDate("data_de_captura").toLocalDate());

					pokemons.add(pokemon);

				}
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return pokemons;
	}

	public static Pokemon save(Pokemon pokemon) {
		String sql = "insert into tb_pokemons(numero, nome, altura, peso, categoria, data_de_captura) values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setLong(1, pokemon.getNumero());
			ps.setString(2, pokemon.getNome());
			ps.setDouble(3, pokemon.getAltura());
			ps.setDouble(4, pokemon.getPeso());
			ps.setString(5, pokemon.getCategoria());
			ps.setDate(6, Date.valueOf(pokemon.getDataDaCaptura()));

			if (ps.executeUpdate() > 0) {
				return pokemon;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
}
