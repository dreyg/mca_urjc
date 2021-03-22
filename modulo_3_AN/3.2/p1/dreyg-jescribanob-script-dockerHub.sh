#!/bin/bash

# Server
docker build -t juaneb/jescribanobdreygserver ./server
docker push juaneb/jescribanobdreygserver

# Planner
cd planner
docker build -f cache-multistage.Dockerfile -t juaneb/jescribanobdreygplanner .
docker push juaneb/jescribanobdreygplanner
cd ..

# Weather
pack build juaneb/grpc-ejem1 --path ./weatherservice --builder gcr.io/buildpacks/builder:v1
docker push juaneb/grpc-ejem1

# TopoService
cd toposervice
mvn compile jib:build -Dimage=juaneb/jescribanobdreygtoposervice
cd ..