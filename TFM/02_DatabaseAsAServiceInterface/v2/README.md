# Prerequisites
## Login to Dockerhub
```
docker login
```

## Build the Order docker image
```
docker build -t dreyg/database_as_a_service_order_v2 ./order
```
## Push the Order docker image
```
docker push dreyg/database_as_a_service_order_v2
```

## Build the external consumer service docker image
```
docker build -t dreyg/database_as_a_service_external_consumer_v2 ./externalConsumer
```

## Push the external consumer service docker image
```
docker push dreyg/database_as_a_service_external_consumer_v2
```

## Registering a connector to monitor the inventory database

curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" localhost:8083/connectors/ -d @conector-mysql.json


--> Windows user
curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" localhost:8083/connectors/ -d '{ \"name\": \"inventory-connector\", \"config\": { \"connector.class\": \"io.debezium.connector.mysql.MySqlConnector\", \"tasks.max\": \"1\", \"database.hostname\": \"mysql\", \"database.port\": \"3306\", \"database.user\": \"debezium\", \"database.password\": \"dbz\", \"database.server.id\": \"184054\", \"database.server.name\": \"dbserver1\", \"database.include.list\": \"inventory\", \"database.history.kafka.bootstrap.servers\": \"kafka:9092\", \"database.history.kafka.topic\": \"dbhistory.inventory\" } }'
--> No me funciona.... lo he creado en Linux:
curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" localhost:8083/connectors/ -d '{ "name": "inventory-connector", "config": { "connector.class": "io.debezium.connector.mysql.MySqlConnector", "tasks.max": "1", "database.hostname": "mysql", "database.port": "3306", "database.user": "debezium", "database.password": "dbz", "database.server.id": "184054", "database.server.name": "dbserver1", "database.include.list": "inventory", "database.history.kafka.bootstrap.servers": "kafka:9092", "database.history.kafka.topic": "dbhistory.inventory" } }'
-->
docker run -it --rm --name watcher --link zookeeper:zookeeper --link kafka:kafka debezium/kafka:1.6 watch-topic -a -k dbserver1.inventory.customers
