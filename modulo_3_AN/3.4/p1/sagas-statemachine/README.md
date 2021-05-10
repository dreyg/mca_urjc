# Ejecución

## Arranque de mysql y kafka
docker-compose -f docker-compose-mysql.yaml up

## Parada de mysql y Kafka
docker-compose -f docker-compose-mysql.yaml down

## Terminal en gateway-service
mvn spring-boot:run

## Terminal en order-service
mvn spring-boot:run

## Terminal en city-service
mvn spring-boot:run

## Terminal en customer-service
mvn spring-boot:run

## Terminal en delivery-service
mvn spring-boot:run

# API endpoints

Se adjuntan 4 colecciones para probar los distintos escenarios que se solicitan: 

# orderState    rejectionReason    comentario
  Prácticas microservicios Test automáticos- ESCENARIO 1 (APPROVED).postman_collection
  APPROVED                             el pedido cumple con todos los requisitos del sistema. 

  Prácticas microservicios Test automáticos- ESCENARIO 2 (CREDIT_REJECTED).postman_collection
  REJECTED        INSUFFICIENT_CREDIT             Pedido rechazado porque falla el saldo del cliente.

  Prácticas microservicios Test automáticos- ESCENARIO 3 (ALLOCATION_FAILED).postman_collection
  REJECTED        SOLD_OUT       Pedido rechazado porque falla el stock del producto.   

  Prácticas microservicios Test automáticos- ESCENARIO 4 (ALLOCATION_DELIVERY_FAILED).postman_collection
  REJECTED        SOLD_OUT      Pedido rechazado porque no hay disponibilidad de delivery a esa ciudad 
 
# Notas de la ejecución de los test: 

- Importar las colecciones en Postman (dentro de la carpeta /postman del proyecto). La ejecución automática de la colección nos ha generado error pero al ejecutarlos secuencialmente y uno a uno nos devuelve el resultado esperado.


# Notas de la práctica: 

- Aunque hemos implementado el nuevo microservicio y adaptado todos los estados de la máquina, comprendiendo el flujo de la máquina de estados, nos falla las transacciones de compensación ya que la cola de deallocate-order-request no escuchaba cuando mandábamos deshacer la operación de reserva de producto.