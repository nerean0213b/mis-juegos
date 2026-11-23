package com.misjuegos.modelo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of="id")
@Builder
@Entity
@Table(name="juego")
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="rawg_id")
	private Integer rawgId;
	@NotBlank
	private String titulo;
	private String plataforma;
	private String genero;
	@Column(name="portada_url")
	private String portadaUrl;
	@Enumerated(EnumType.STRING)
	private EstadoJuego estado;
	@JdbcTypeCode(SqlTypes.TINYINT)
	@Min(0)
	@Max(10)
	private Integer puntuacion;
	private BigDecimal horas;
	@Column(columnDefinition = "TEXT")
	private String notas;
	@Column(name="fecha_alta")
	private LocalDate fechaAlta;
	
	
}
