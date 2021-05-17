# Practica 2. Microservicios

## Construcción de imágenes

### Construimos la imagen de monolith
- docker build -t juaneb/dreyg-jescribanob-monolith .

### Construimos la imagen de users_ms
- docker build -t juaneb/dreyg-jescribanob-users_ms .

### Subimos la imagen de monolith a DockerHub
- docker push juaneb/dreyg-jescribanob-monolith

### Subimos la imagen de users_ms a DockerHub
- docker push juaneb/dreyg-jescribanob-users_ms

## Preparación del entorno de ejecución

### Activamos el cluster de kubernetes
- minikube start --cni=cilium --memory=8192 --no-vtx-check --driver=virtualbox

### Activamos el ingress
- minikube addons enable ingress

### Sacamos la IP de minikube y la asociamos al host "split-the-monolith"
- minikube ip

## Prueba del monolito: 
### Desplegamos los manifiestos del monolito
kubectl apply -f .\k8s\monolith_deployment


## Prueba del microservicio: 
### Desplegamos los manifiestos del microservicio
kubectl apply -f .\k8s\ms_deployment



