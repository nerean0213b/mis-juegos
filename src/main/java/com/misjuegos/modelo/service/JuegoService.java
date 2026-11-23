package com.misjuegos.modelo.service;

import java.util.List;

import com.misjuegos.modelo.entidades.EstadoJuego;
import com.misjuegos.modelo.entidades.Juego;

public interface JuegoService {

	Juego insertOne(Juego juego);
	Juego buscarUno(int id);
	List<Juego> buscarTodos();
	List<Juego> buscarPorEstado(EstadoJuego estado);
	List<Juego> buscarPorTitulo(String cadena);
	List<Juego> buscarPorGenero(String genero);
	List<Juego> buscarPorPlataforma(String plataforma);
	List<Juego> buscarPorPuntuacionMayorOIgual(Integer puntuacion);
	Juego modificarJuego(Juego juego);
	Juego eliminarJuego(int id);

}
