package com.misjuegos.restcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misjuegos.modelo.entidades.EstadoJuego;
import com.misjuegos.modelo.entidades.Juego;
import com.misjuegos.modelo.service.JuegoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/juegos")
@CrossOrigin(origins="*")
public class JuegosRestController {
	
	private JuegoService juegoService;
	
	public JuegosRestController(JuegoService juegoService) {
		this.juegoService=juegoService;
	}

	@GetMapping("/")
	public List<Juego> todos(){
		return juegoService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> uno(@PathVariable int id){
		Juego juego=juegoService.buscarUno(id);
		if(juego!=null)
			return ResponseEntity.ok(juego);
		return ResponseEntity.status(404).body("no existe el juego " + id);
	}
	
	@GetMapping("/estado/{estado}")
	public List<Juego> buscarPorEstado(@PathVariable EstadoJuego estado){
		return juegoService.buscarPorEstado(estado);
	}
	
	@GetMapping("/titulo/{cadena}")
	public List<Juego> buscarPorTitulo(@PathVariable String cadena){
		return juegoService.buscarPorTitulo(cadena);
	}
	
	@GetMapping("/genero/{genero}")
	public List<Juego> buscarPorGenero(@PathVariable String genero){
		return juegoService.buscarPorGenero(genero);
	}
	
	@GetMapping("/plataforma/{plataforma}")
	public List<Juego> buscarPorPlataforma(@PathVariable String plataforma){
		return juegoService.buscarPorPlataforma(plataforma);
	}
	
	@GetMapping("/puntuacion/{puntuacion}")
	public List<Juego> buscarPorPuntuacion(@PathVariable Integer puntuacion){
		return juegoService.buscarPorPuntuacionMayorOIgual(puntuacion);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> alta(@Valid @RequestBody Juego juego){
		return ResponseEntity.status(201).body(juegoService.insertOne(juego));
	}
	
	@PutMapping("/")
	public ResponseEntity<?> modificar(@Valid @RequestBody Juego juego){
		Juego modificado=juegoService.modificarJuego(juego);
		if(modificado != null)
			return ResponseEntity.ok(modificado);
		return ResponseEntity.status(404).body("No existe el juego");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id){
		Juego eliminado=juegoService.eliminarJuego(id);
		if(eliminado != null)
			return ResponseEntity.ok(eliminado);
		return ResponseEntity.status(404).body("No existe el juego " + id);
	}
	
	
}
