package com.misjuegos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misjuegos.modelo.entidades.EstadoJuego;
import com.misjuegos.modelo.entidades.Juego;
import org.springframework.data.jpa.repository.Query;

public interface JuegoRepository extends JpaRepository<Juego, Integer>{
		@Query("SELECT j FROM Juego j WHERE j.estado = :estado")
		List<Juego> findByEstado(EstadoJuego estado);
		List<Juego> findByTituloContainingIgnoreCase(String cadena);
		List<Juego> findByGenero(String genero);
		List<Juego> findByPlataforma(String plataforma);
		List<Juego> findByPuntuacionGreaterThanEqual(Integer puntuacion);
	
}
