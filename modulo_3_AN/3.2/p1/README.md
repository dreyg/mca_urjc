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

## Server

1- Definimos una red
docker network create server-network

2- Creamos los servicios auxiliares la bbdd mysql + rabbitmq
docker run --rm -d --network server-network -v "$PWD":/data -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=eoloplantsDB -p 3306:3306 --name mysql mysql:8.0.22
docker run --rm -d --network server-network -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3-management  

3- Creamos el fichero "Dockerfile"

4- Creamos la imagen del server con el fichero DockerFile del punto 3
docker build -t jescribanobdreyg/server .

5- Ejecutamos el contenedor con la imagen creada en el punto 4
docker run --rm -d --network server-network -e MYSQL_HOST="mysql" --name server -p 3000:3000 jescribanobdreyg/server



## Planner
1- Creamos el fichero "cache-multistage.Dockerfile"

2- Creamos la imagen docker a partir del fichero del punto 1
docker build -f cache-multistage.Dockerfile -t jescribanobdreyg/planner .

3- Creamos variable de entorno en el propierties con el nombre del host del rabbitmq
spring.rabbitmq.host=${RABBITMQ_HOST} # RabbitMQ host.

4- Ejecutamos el contenedor con la imagen creada en el punto 2
docker run -d --rm --network server-network --name planner -e spring.rabbitmq.host="rabbitmq" -e grpc.client.weatherServer.address="static://weatherService:9090" jescribanobdreyg/planner


## WeatherService
1- Instalación componente BuildPacks
https://buildpacks.io/docs/tools/pack/

2- Construyo la imagen
pack build dreygjescribanob/grpc-ejem1 --path . --builder gcr.io/buildpacks/builder:v1

3- Desplego el contenedor con la imagen del punto 2
docker run -d --rm --network server-network --name weatherService dreygjescribanob/grpc-ejem1


## TopoService
1- Me logo en dockerHub
docker login 

2- Compilo la imagen con JIB. Queda subida automáticamente a DockerHub 
mvn compile jib:build -Dimage=juaneb/toposervice

3- Arranco el servicio de Mongo
docker run -d -p 27017:27017 -v "$PWD":/data --network server-network --name mongo -e MONGO_INITDB_DATABASE="topo" mongo 

4- Desplego el contenedor
docker run -d --rm --network server-network --name topoService -e spring.data.mongodb.host="mongo" -e spring.data.mongodb.port="27017" -e spring.data.mongodb.database="topo" juaneb/toposervice 



#### CONSTRUCCIÓN IMAGÉNES ######
docker network create server-network
docker build -t jescribanobdreyg/server .




#### ARRANQUE TODOS LOS SERVICIOS ######
--> Auxiliares
docker run --rm -d --network server-network -v "$PWD":/data -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=eoloplantsDB -p 3306:3306 --name mysql mysql:8.0.22
docker run --rm -d --network server-network -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3-management
docker run -d -p 27017:27017 -v "$PWD":/data --network server-network --name mongo -e MONGO_INITDB_DATABASE="topo" mongo

--> Aplicación
docker run --rm -d --network server-network -e MYSQL_HOST="mysql" --name server -p 3000:3000 jescribanobdreyg/server
docker run -d --rm --network server-network --name planner -e spring.rabbitmq.host="rabbitmq" -e grpc.client.weatherServer.address="static://weatherService:9090" jescribanobdreyg/planner
docker run -d --rm --network server-network --name weatherService dreygjescribanob/grpc-ejem1
docker run -d --rm --network server-network --name topoService -e spring.data.mongodb.host="mongo" -e spring.data.mongodb.port="27017" -e spring.data.mongodb.database="topo" juaneb/toposervice
