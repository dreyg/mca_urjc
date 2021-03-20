# EoloPlanner

Este proyecto es una aplicación distribuida formada por diferentes servicios que se comunican entre sí usando API REST, gRPC y RabbitMQ. La aplicación ofrece un interfaz web que se comunica con el servidor con API REST y WebSockets. 

Algunos servicios están implementados con Node.js/Express y otros con Java/Spring. Estas tecnologías deben estar instaladas en el host para poder construir y ejecutar los servicios. También se requiere Docker para ejecutar los servicios auxiliares (MySQL, MongoDB y RabbitMQ).

Para la construcción de los servicios y su ejecución, así como la ejecución de los servicios auxiliares requeridos se usan scripts implementados en Node.js. Posiblemente no sea el lenguaje de scripting más utilizado para este caso de uso, pero en este caso concreto facilita la interoperabilidad en varios SOs y es sencillo.

Esta solución está basada en el trabajo entregado por el alumno Miguel García Sanguino.

## Iniciar servicios auxiliares: MongoDB, MySQL y RabbitMQ

Los servicios auxiliares se ejecutan con la tecnología de contenedores Docker usando el siguiente comando:

```
$ node exec_aux_services.js
```

## Construir servicios

Descarga las dependencias y construye los proyectos. En proyectos Java usa Maven. En proyectos Node usa NPM:

```
$ node build.js
```

## Ejecutar servicios

Ejecuta los servicios. En proyectos Java usa Maven. En proyectos Node usa esta tecnología directamente:

```
$ node exec.js
```

# EJECUCIÓN DE LA APLICACIÓN CON DOCKER

Dockerizar los siguientes servicios:

## MySQL para el Planner

1- definimos una red
$ docker network create server-network
2- creamos la bdd mysql + rabbitmq
$ docker run --rm -d --network server-network -v "$PWD":/data -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=eoloplantsDB -p 3306:3306 --name mysql mysql:8.0.22'
$ docker run --rm -d --network server-network -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3-management  

## Creamos Server con la bdd

docker build -t jescribanobdreyg/server .
docker run --rm --network server-network --name server -p 3000:3000 jescribanobdreyg/server

## Planner

docker build -f multistage.Dockerfile -t jescribanobdreyg/planner .