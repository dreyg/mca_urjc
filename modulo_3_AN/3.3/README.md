# Hoja de ruta práctica 1 módulo 3.3 "Escalabilidad y tolerancia a fallos"

## Pre-requisitos. 

- Arrancamos minikube con el driver de VirtualBox

minikube start --cni=cilium --memory=8192 --no-vtx-check --driver=virtualbox

- Desplegamos la aplicación

kubectl apply -f .\k8s\

- Ejecutamos la aplicación

## Modificaciones

- Modificamos el POM para meter la dependencia con HazelCast

		<dependency>
			<groupId>org.springframework.session</groupId>
			<artifactId>spring-session-hazelcast</artifactId>
		</dependency>
		<dependency>
			<groupId>com.hazelcast</groupId>
			<artifactId>hazelcast</artifactId>
		</dependency>

		 <dependency>
			<groupId>com.hazelcast</groupId>
			<artifactId>hazelcast-kubernetes</artifactId>	
			<version>2.0</version>			
		</dependency>

- Nos creamos el fichero que dará permisos a HazelCast para conectarse a la API de Kubernetes grantsHazelCast.yml

- Creamos el servicio de HazelCast. Para ello, hemos adaptado el service del webapp añadiendo el nombre y el puerto:

      port: 5701
      name: hazelcast

- Creamos el fichero de configuración
	hazelcast.yaml

- Quitamos la dependencia del POM que hace referencia al plugin de google:

<plugin>
				<groupId>com.google.cloud.tools</groupId>
				<artifactId>jib-maven-plugin</artifactId>
				<version>3.0.0</version>
				<configuration>
					<to>
						<image>juaneb/dreyg-jescribanob-escalabilidad</image>
						<tags>
							<tag>0.0.1</tag>
						</tags>
					</to>
					<container>
						<mainClass>es.codeurjc.kubetest.Application</mainClass>
						<ports>
							<port>8080</port>
						</ports>
					</container>
					<jvmFlags>
						<jvmFlag>-Djava.security.edg=file:/dev/./urandom</jvmFlag>
					</jvmFlags>
				</configuration>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>build</goal>
						</goals>
					</execution>
				</executions>
			</plugin>


- Construimos la imagen:

docker build -t juaneb/dreyg-jescribanob-escalabilidad .

- Subimos la imagen a dockerhub:

docker push juaneb/dreyg-jescribanob-escalabilidad

- Levantamos el servicio

minikube service webapp

- Ejecutar el test

mvn test -Dweburl=http://192.168.49.2:31940


## Prueba de carga

## Tips

### Redimensión de pods
kubectl scale deployment/webapp --replicas=1

### Instalación artillery

npm install -g artillery

### Escenario 1: Un único pod en el deployment. No caos testing
artillery quick --duration 300 --count 100 --num 20 --output resultTestEscenario1.json  http://192.168.99.119:30722/

artillery report --output resultTestEscenario1.html resultTestEscenario1.json

### Escenario 2: Un único pod en el deployment. Caos testing con chaos-pod-monkey.

#### Creación del fichero deployment.yaml
Nos copiamos el fichero del ejemplo ejem6-pod-chaos-monkey y le modificamos:

- La imagen: jnewland/kubernetes-pod-chaos-monkey
- Las etiquuetas TAG y VALUE para que ataquen a nuestra apliación

#### Desplegamos el chao-monkey
kubectl apply -f .\chaosMonkey\

#### Lanzamos la prueba
artillery quick --duration 300 --count 100 --num 20 --output resultTestEscenario2.json  http://192.168.99.119:30722/

artillery report --output resultTestEscenario2.html resultTestEscenario2.json


### Escenario 3: Dos pods en el deployment. Caos testing con chaos-pod-monkey.


#### Redimensión de pods
kubectl scale deployment/webapp --replicas=2

#### Desplegamos el chao-monkey
kubectl apply -f .\chaosMonkey\


#### Lanzamos la prueba
artillery quick --duration 300 --count 100 --num 20 --output resultTestEscenario3.json  http://192.168.99.119:30722/		

artillery report --output resultTestEscenario3.html resultTestEscenario3.json


### Escenario 4: Escenario 4: Dos pods en el deployment. Uso de Gateway de Istio para aceptar peticiones. Caos testing con chaos-pod-monkey.

#### Pre-requisitos. 

- Arrancamos minikube con el driver de VirtualBox. Metemos mucha memoria...
minikube start --cni=cilium --memory=16384 --cpus=4 --no-vtx-check --driver=virtualbox

- Instalamos istio
https://istio.io/latest/docs/setup/install/

- Nos damos los perfiles
istioctl install --set profile=demo -y

- Nos damos los labels
kubectl label namespace default istio-injection=enabled

#### Creamos los recursos necesarios para lanzar Istio:
- Creación del Gateway
- Creación del VirtualService


#### Desplegamos Istio
kubectl apply -f .\istio\

#### Lanzamos la prueba
artillery quick --duration 300 --count 100 --num 20 --output resultTestEscenario4.json  http://192.168.99.119:30722/		

artillery report --output resultTestEscenario4.html resultTestEscenario4.json




