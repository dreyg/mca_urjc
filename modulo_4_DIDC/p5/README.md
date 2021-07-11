# Práctica 2. Despliegue continuo con Istio, VirtualService y DestionationRule

1. Desplegamos el deployment y el service de la BBDD

    ` kubectl apply -f .\1_db-deployment.yaml `

2. Desplegamos el deployment y el service de la V1 de la aplicación. Previamente la hemos subido a DockerHub

    ` kubectl apply -f .\2_deployment-v1.yaml `

3. Desplegamos el gateway Istio, para enrutar el tráfico a través de Istio:

    ` kubectl apply -f .\3_zerodowntime-gateway.yaml `

4. Desplegamos el VirtualService para que istio dirija el tráfico únicamente a la v1 de la aplicación, que es la que actualmente está levantada:

    ` kubectl apply -f .\4_zerodowntime-virtualservice-v1.yaml `

5. Desplegamos la v2 de la aplicación. De momento no recibe ninguna petición, ya que istio únicamente está dirgiendo tráfico a la V1:

    ` kubectl apply -f .\5_deployment-v2.yaml `

6. Desplegamos el DestinationRule para que comience a repartir el tráfico entre las dos versiones que están desplegadas:

    ` kubectl apply -f .\6_zerodowntime-destinationrule.yaml `

7. Desplegamos el VirtualService v2 para con un 90% del tráfico dirigido a la v1 y un 10% a la V2:

    ` kubectl apply -f .\7_zerodowntime-virtualservice-v2.yaml `

8. Desplegamos el VirtualService v3 para con un 0% del tráfico dirigido a la v1 y un 100% a la V2:

    ` kubectl apply -f .\8_zerodowntime-virtualservice-v3.yaml `

9. Eliminamos la versión antigua

    ` kubectl delete deployment zerodowntime-v1 `

10. Vuelvo a dejar el VirtualService sin reparto de pesos entre las versiones:

    ` kubectl apply -f .\9_zerodowntime-virtualservice-v4.yaml ` 

11. Eliminamos el DestinationRule

    ` kubectl delete destinationrule helloworld `