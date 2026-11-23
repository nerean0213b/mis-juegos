package com.misjuegos.modelo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.misjuegos.modelo.entidades.EstadoJuego;
import com.misjuegos.modelo.entidades.Juego;
import com.misjuegos.modelo.repository.JuegoRepository;
@Service
public class JuegoServiceImpl implements JuegoService {

	private JuegoRepository juegoRepository;
	
	public JuegoServiceImpl(JuegoRepository juegoRepository) {
		this.juegoRepository=juegoRepository;
	}
	
	@Override
	public Juego insertOne(Juego juego) {
		juego.setId(null);
		if(juego.getPlataforma()==null)
			juego.setPlataforma("Nintendo Switch");
		if(juego.getEstado()==null)
			juego.setEstado(EstadoJuego.PENDIENTE);
		if(juego.getHoras()==null)
			juego.setHoras(BigDecimal.ZERO);
		if(juego.getFechaAlta()==null)
			juego.setFechaAlta(LocalDate.now());
		return juegoRepository.save(juego);
	}

	@Override
	public Juego buscarUno(int id) {
		return juegoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Juego> buscarTodos() {
		return juegoRepository.findAll();
	}

	@Override
	public List<Juego> buscarPorEstado(EstadoJuego estado) {
		return juegoRepository.findByEstado(estado);
	}

	@Override
	public List<Juego> buscarPorTitulo(String cadena) {
		return juegoRepository.findByTituloContainingIgnoreCase(cadena);
	}

	@Override
	public List<Juego> buscarPorGenero(String genero) {
		return juegoRepository.findByGenero(genero);
	}

	@Override
	public List<Juego> buscarPorPlataforma(String plataforma) {
		return juegoRepository.findByPlataforma(plataforma);
	}

	@Override
	public List<Juego> buscarPorPuntuacionMayorOIgual(Integer puntuacion) {
		return juegoRepository.findByPuntuacionGreaterThanEqual(puntuacion);
	}

	@Override
	public Juego modificarJuego(Juego juego) {
		if(juego.getId() != null && juegoRepository.existsById(juego.getId()))
				return juegoRepository.save(juego);
		return null;
	}

	@Override
	public Juego eliminarJuego(int id) {
		Juego juego=juegoRepository.findById(id).orElse(null);
		if(juego != null) {
			juegoRepository.deleteById(id);
		}
		return juego;
	}

}
