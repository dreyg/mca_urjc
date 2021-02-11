


-- test.hibernate_sequence definition

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.avion definition

CREATE TABLE `avion` (
                         `id` bigint NOT NULL,
                         `cod_avion` varchar(255) DEFAULT NULL,
                         `fabricante` varchar(255) DEFAULT NULL,
                         `horas_vuelo` int DEFAULT NULL,
                         `modelo` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- test.aeropuerto definition

CREATE TABLE `aeropuerto` (
                              `id` bigint NOT NULL,
                              `ciudad` varchar(255) DEFAULT NULL,
                              `cod_aeropuerto` varchar(255) DEFAULT NULL,
                              `nombre` varchar(255) DEFAULT NULL,
                              `pais` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB;


-- test.vuelo definition

CREATE TABLE `vuelo` (
                         `id` bigint NOT NULL,
                         `cod_vuelo` varchar(255) DEFAULT NULL,
                         `compania` varchar(255) DEFAULT NULL,
                         `duracion_vuelo` float DEFAULT NULL,
                         `fecha_hora_llegada` datetime(6) DEFAULT NULL,
                         `fecha_hora_salida` datetime(6) DEFAULT NULL,
                         `aeropuerto_destino_id` bigint DEFAULT NULL,
                         `aeropuerto_origen_id` bigint DEFAULT NULL,
                         `avion_id` bigint DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FK9xo70cdouhq652fqt3e80ft1f` (`aeropuerto_destino_id`),
                         KEY `FKfyhftl5i1s3cd6lf6eufefds6` (`aeropuerto_origen_id`),
                         KEY `FK8j5widj67y5mcf830eqkvth2p` (`avion_id`),
                         CONSTRAINT `FK8j5widj67y5mcf830eqkvth2p` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`),
                         CONSTRAINT `FK9xo70cdouhq652fqt3e80ft1f` FOREIGN KEY (`aeropuerto_destino_id`) REFERENCES `aeropuerto` (`id`),
                         CONSTRAINT `FKfyhftl5i1s3cd6lf6eufefds6` FOREIGN KEY (`aeropuerto_origen_id`) REFERENCES `aeropuerto` (`id`)
) ENGINE=InnoDB;


-- test.tripulante definition

CREATE TABLE `tripulante` (
                              `id` bigint NOT NULL,
                              `apellidos` varchar(255) DEFAULT NULL,
                              `cod_empleado` varchar(255) DEFAULT NULL,
                              `empresa` varchar(255) DEFAULT NULL,
                              `nombre` varchar(255) DEFAULT NULL,
                              `puesto` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- test.vuelo_tripulante definition

CREATE TABLE `vuelo_tripulante` (
                                    `tri_id` bigint NOT NULL,
                                    `vue_id` bigint NOT NULL,
                                    PRIMARY KEY (`tri_id`,`vue_id`),
                                    KEY `FK34vbqreno020imnyelgbql1nl` (`vue_id`),
                                    CONSTRAINT `FK34vbqreno020imnyelgbql1nl` FOREIGN KEY (`vue_id`) REFERENCES `vuelo` (`id`),
                                    CONSTRAINT `FKk4lbbylr4jt7egl9nnuautdir` FOREIGN KEY (`tri_id`) REFERENCES `tripulante` (`id`)
) ENGINE=InnoDB;


-- test.mecanico definition

CREATE TABLE `mecanico` (
                            `id` bigint NOT NULL,
                            `apellidos` varchar(255) DEFAULT NULL,
                            `cod_empleado` varchar(255) DEFAULT NULL,
                            `empresa` varchar(255) DEFAULT NULL,
                            `nombre` varchar(255) DEFAULT NULL,
                            `anio_incorporacion` int DEFAULT NULL,
                            `formacion_previa` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- test.revision definition

CREATE TABLE `revision` (
                            `id` bigint NOT NULL,
                            `descripcion_trabajo` varchar(255) DEFAULT NULL,
                            `fecha_fin` datetime(6) DEFAULT NULL,
                            `fecha_inicio` datetime(6) DEFAULT NULL,
                            `num_horas_empleadas` int DEFAULT NULL,
                            `tipo_revision` varchar(255) DEFAULT NULL,
                            `aeropuerto_id` bigint DEFAULT NULL,
                            `avion_id` bigint DEFAULT NULL,
                            `mecanico_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FK5clx7t15sygeqxsqfxl57rpme` (`aeropuerto_id`),
                            KEY `FKepufjqvypljnk6si1dhtdcn3r` (`avion_id`),
                            KEY `FKne5fxcl7x184sgqlmh6kxneqo` (`mecanico_id`),
                            CONSTRAINT `FK5clx7t15sygeqxsqfxl57rpme` FOREIGN KEY (`aeropuerto_id`) REFERENCES `aeropuerto` (`id`),
                            CONSTRAINT `FKepufjqvypljnk6si1dhtdcn3r` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`),
                            CONSTRAINT `FKne5fxcl7x184sgqlmh6kxneqo` FOREIGN KEY (`mecanico_id`) REFERENCES `mecanico` (`id`)
) ENGINE=InnoDB;

INSERT INTO test.avion (id,cod_avion,fabricante,horas_vuelo,modelo) VALUES (1,'BOI001','Boing',2500,'Boing 737');
INSERT INTO test.avion (id,cod_avion,fabricante,horas_vuelo,modelo) VALUES (2,'BOI002','Boing',1500,'Boing 777');
INSERT INTO test.avion (id,cod_avion,fabricante,horas_vuelo,modelo) VALUES (3,'BOI003','Boing',5500,'Boing 767');
INSERT INTO test.avion (id,cod_avion,fabricante,horas_vuelo,modelo) VALUES (4,'AIR001','Airbus',2500,'A340');
INSERT INTO test.avion (id,cod_avion,fabricante,horas_vuelo,modelo) VALUES (5,'AVI002','Airbus',4500,'A380');
INSERT INTO test.avion (id,cod_avion,fabricante,horas_vuelo,modelo) VALUES (6,'AVI003','Airbus',6500,'A400');

INSERT INTO test.mecanico (id,apellidos,cod_empleado,empresa,nombre,anio_incorporacion,formacion_previa) VALUES (7,'Ruiz Garcia','MEC001','Airbus','Roberto',1995,'');
INSERT INTO test.mecanico (id,apellidos,cod_empleado,empresa,nombre,anio_incorporacion,formacion_previa) VALUES (8,'Tola Cruz','MEC002','Airbus','Rebeca',1992,'');
INSERT INTO test.mecanico (id,apellidos,cod_empleado,empresa,nombre,anio_incorporacion,formacion_previa) VALUES (9,'Muñoz Rodriguez','MEC003','Airbus','Ruben',1998,'');
INSERT INTO test.mecanico (id,apellidos,cod_empleado,empresa,nombre,anio_incorporacion,formacion_previa) VALUES (10,'Lopez Perez','MEC004','Airbus','Ramon',2005,'');

INSERT INTO test.aeropuerto (id,ciudad,cod_aeropuerto,nombre,pais) VALUES (11,'Madrid','MAD01','Barajas','España');
INSERT INTO test.aeropuerto (id,ciudad,cod_aeropuerto,nombre,pais) VALUES (12,'Madrid','MAD02','Cuatro Vientos','España');
INSERT INTO test.aeropuerto (id,ciudad,cod_aeropuerto,nombre,pais) VALUES (13,'Barcelona','BAR01','El prat','España');

INSERT INTO test.vuelo (id,cod_vuelo,compania,duracion_vuelo,fecha_hora_llegada,fecha_hora_salida,aeropuerto_destino_id,aeropuerto_origen_id,avion_id) VALUES (14,'IBE001','Iberia',0.45,'2021-02-11 19:24:09.817000000','2021-02-11 18:57:09.817000000',13,11,1);
INSERT INTO test.vuelo (id,cod_vuelo,compania,duracion_vuelo,fecha_hora_llegada,fecha_hora_salida,aeropuerto_destino_id,aeropuerto_origen_id,avion_id) VALUES (18,'IBE002','Iberia',0.45,'2021-02-11 16:37:29.818000000','2021-02-11 16:10:29.818000000',13,12,2);

INSERT INTO test.tripulante (id,apellidos,cod_empleado,empresa,nombre,puesto) VALUES (15,'Lopez Frau','COM001','IBERIA','Alberto','Comanadante');
INSERT INTO test.tripulante (id,apellidos,cod_empleado,empresa,nombre,puesto) VALUES (16,'Fernandez Lopez','COM002','IBERIA','Alvaro','Co-Piloto');
INSERT INTO test.tripulante (id,apellidos,cod_empleado,empresa,nombre,puesto) VALUES (17,'Gonzalez Ruiz','COM003','IBERIA','Antonio','Sobrecargo');
INSERT INTO test.tripulante (id,apellidos,cod_empleado,empresa,nombre,puesto) VALUES (19,'Gomez Sanchez','COM004','IBERIA','Juan','Comanadante');
INSERT INTO test.tripulante (id,apellidos,cod_empleado,empresa,nombre,puesto) VALUES (20,'Jimenez Diaz','COM005','IBERIA','Pedro','Co-Piloto');
INSERT INTO test.tripulante (id,apellidos,cod_empleado,empresa,nombre,puesto) VALUES (21,'Robledo Chavela','COM006','IBERIA','David','Sobrecargo');

INSERT INTO test.vuelo_tripulante (tri_id,vue_id) VALUES (15,14);
INSERT INTO test.vuelo_tripulante (tri_id,vue_id) VALUES (16,14);
INSERT INTO test.vuelo_tripulante (tri_id,vue_id) VALUES (17,14);
INSERT INTO test.vuelo_tripulante (tri_id,vue_id) VALUES (19,18);
INSERT INTO test.vuelo_tripulante (tri_id,vue_id) VALUES (20,18);
INSERT INTO test.vuelo_tripulante (tri_id,vue_id) VALUES (21,18);

INSERT INTO test.revision (id,descripcion_trabajo,fecha_fin,fecha_inicio,num_horas_empleadas,tipo_revision,aeropuerto_id,avion_id,mecanico_id) VALUES (22,'cambio de aceite y revisión del motor','2021-02-11 21:43:40.132000000','2021-02-10 04:03:50.132000000',15,'periodica',11,1,7);
INSERT INTO test.revision (id,descripcion_trabajo,fecha_fin,fecha_inicio,num_horas_empleadas,tipo_revision,aeropuerto_id,avion_id,mecanico_id) VALUES (23,'revisión del motor e interiores','2021-02-11 21:43:30.177000000','2021-02-09 00:17:10.177000000',20,'periodica',12,2,8);
INSERT INTO test.revision (id,descripcion_trabajo,fecha_fin,fecha_inicio,num_horas_empleadas,tipo_revision,aeropuerto_id,avion_id,mecanico_id) VALUES (24,'interiores y cabina','2021-02-11 21:43:20.267000000','2021-02-07 20:30:30.267000000',25,'periodica',13,3,9);
INSERT INTO test.revision (id,descripcion_trabajo,fecha_fin,fecha_inicio,num_horas_empleadas,tipo_revision,aeropuerto_id,avion_id,mecanico_id) VALUES (25,'cabina y asientos','2021-02-11 21:43:10.317000000','2021-02-06 16:43:50.317000000',30,'reparacion',11,4,10);
INSERT INTO test.revision (id,descripcion_trabajo,fecha_fin,fecha_inicio,num_horas_empleadas,tipo_revision,aeropuerto_id,avion_id,mecanico_id) VALUES (26,'reparacion exteriores','2021-02-11 21:43:00.434000000','2021-02-05 12:57:10.434000000',35,'reparacion',12,5,7);
INSERT INTO test.revision (id,descripcion_trabajo,fecha_fin,fecha_inicio,num_horas_empleadas,tipo_revision,aeropuerto_id,avion_id,mecanico_id) VALUES (27,'sustitucion caja negra','2021-02-11 21:42:50.495000000','2021-02-04 09:10:30.495000000',40,'reparacion',13,6,8);

INSERT INTO test.hibernate_sequence (next_val) VALUES (28);