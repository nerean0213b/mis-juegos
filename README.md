API REST para gestionar tu backlog de videojuegos. Permite guardar los juegos que tienes, marcar su estado (pendiente, jugando, terminado o abandonado), apuntar la puntuación y las horas jugadas y filtrarlos de distintas formas.
Tecnologías usadas: Java 25, Spring Boot (Spring Web, Spring Data JPA, Validation), MySQL, Maven y Lombok.
Requisitos para su ejecución: 
	JDK 25
	MySQL en marcha 
	Maven 
Pasos para ejecutarlo:
	1.Clona el repositorio
	git clone https://github.com/nerean0213b/mis-juegos.git
	cd mis-juegos
	2. Crea la base de datos ejecutando el script que está en la carpeta database:
	database/BasesDeDatosMisJuegos.sql
	3.Revisa la conexión en src/main/resources/application.properties y ajusta el usuario y la contraseña de tu MySQL si son distintos:
	properties
	spring.datasource.url=jdbc:mysql://localhost:3306/misjuegos
	spring.datasource.username=root
	spring.datasource.password=
	4.Arranca la aplicación
	./mvnw spring-boot:run
	5.La API queda disponible en 	http://localhost:8088.

Modelo de datos

Tabla juego:
Campo			Tipo	Descripción
id				int		Identificador (autoincremental)
rawg_id			int		Id del juego en la API de RAWG (opcional)
titulo			texto	Título del juego (obligatorio)
plataforma		texto	Por defecto, "Nintendo Switch"
genero			texto	Género del juego
portada_url		texto	Enlace a la portada
estado			enum	PENDIENTE, JUGANDO, TERMINADO o ABANDONADO
puntuacion		int		Nota de 0 a 10 (vacía si aún no lo has valorado)
horas			decimal	Horas jugadas
notas			texto	Notas personales
fecha_alta		fecha	Fecha en la que se añadió

Endpoints

Ruta base: http://localhost:8088/juegos

Método	Ruta							Descripción
GET		/juegos/						Lista todos los juegos
GET		/juegos/{id}					Devuelve un juego por su id
GET		/juegos/estado/{estado}			Filtra por estado (en mayúsculas, p. ej. JUGANDO)
GET		/juegos/titulo/{cadena}			Busca juegos cuyo título contiene el texto
GET		/juegos/genero/{genero}			Filtra por género
GET		/juegos/plataforma/{plataforma}	Filtra por plataforma
GET		/juegos/puntuacion/{puntuacion}	Juegos con esa nota o más
POST	/juegos/						Añade un juego
PUT		/juegos/						Modifica un juego (se envía completo, con su id)
DELETE	/juegos/{id}					Elimina un juego


Estructura del proyecto
src/main/java/com/misjuegos
├── modelo
│   ├── entidades     → Juego, EstadoJuego
│   ├── repository    → JuegoRepository
│   └── service       → JuegoService, JuegoServiceImpl
└── restcontroller    → JuegosRestController
database/             → script SQL de la base de datos

Próximos pasos
-Integrar la API de RAWG para rellenar automáticamente la portada y los datos del juego
-Frontend en JavaScript
-Estadísticas (horas totales, juegos terminados, género más jugado)
-Botón "¿A qué juego hoy?" que elija uno al azar del -Despliegue online

Autora: Nerea Martín Bravo — @nerean0213b