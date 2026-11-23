Create database if not exists misjuegos
	character set utf8mb4
    collate utf8mb4_unicode_ci;

use misjuegos;

create table juego (
	id int auto_increment primary key,
    rawg_id int null,
    titulo varchar(200) not null,
    plataforma varchar(50) not null default "Nintendo Switch",
    genero varchar(70),
    portada_url varchar(500),
    estado enum("PENDIENTE","JUGANDO","TERMINADO","ABANDONADO") NOT null default "PENDIENTE",
    puntuacion tinyint null check(puntuacion between 0 and 10),
    horas decimal(6,1) not null default 0,
    notas text,
    fecha_alta date not null default (current_date)
);