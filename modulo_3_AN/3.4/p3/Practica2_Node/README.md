# p3-serverless

El objetivo de esta práctica consiste en implementar una API REST con las tecnologías serverless ofrecidas por AWS. En concreto, se utilizarán las siguientes:

* API Gateway
* Lambda
* DynamoDB
* SAM

## Pre-requisitos y contexto

Para la ejecución de esta práctica, instalaremos el framework  AWS Serverless Application Model (SAM). Sam es un framework para desarrollo de aplicaciones
serverless. PAra ellos se instala el CLI de SAM siguiendo la documentación mostrada en clase.

## Arquitectura

Se plantea una arquitectura formada íntegramente por servicios de AWS en concreto:

- Api Gateway: Hará de enrutador de las peticiones.
- 17 funciones Lambda. Cada función Lambda atenderá únicamente una petición, no habrá funciones monolíticas.
- DynamoDB formado por 3 tablas: users, books, comments

## Funciones Lambda

- Cada función atenderá una única petición y todas seguirán la misma estructura:

Importará la función manejadora de la BBDD:
```
const dbManager = require('dbManagerUser');
```

Exportará la función con el manejador de la función lambda:
```
exports.getAllUsersHandler = (event, context, callback) => {
    console.log("Dentro de la función LAMBDA")
    getAllUsers(callback);
};
```
Existirá un callback que se ejecutará al recibir el evento que maneja la función:
```
const getAllUsers = (callback) => {
    dbManager.getAllUsers()
    .then((res) => {
        sendResponse(200, res, callback);
    })
    .catch((err) => {
        console.log(err);
        sendResponse(200, err, callback);
    });
};
```

Devolverá la respuesta:
```
const sendResponse = (statusCode, message, callback) => {
    const res = {
        statusCode: statusCode,
        body: JSON.stringify(message)
    };
    callback(null, res);
};
```


## Recursos
Para el despliegue de los recursos necesarios, crearemos un fichero "template.yaml". Los recursos que se crearán serán los siguientes:

- 17 recursos de tipo Type: 'AWS::Serverless::Function' (funciones lambda). En él crearemos las propiedades, eventos y políticas necesarias para su ejecución: 

Un ejemplo de recurso de función lambda sería el siguiente:

```
    getAllUsersFunction:
    # This resource creates a Lambda function.
        Type: 'AWS::Serverless::Function'
        Properties:
            # This function uses the Nodejs v8.10 runtime.
            Runtime: nodejs14.x
            # This is the Lambda function's handler.
            Handler: getAllUsers.getAllUsersHandler
            # The location of the Lambda function code.
            CodeUri: ./src/users/
            # Event sources to attach to this function. In this case, we are attaching
            # multiple API Gateway endpoints to the Lambda function. The function is
            # called when a HTTP request is made to the API Gateway endpoint.
            Events:
                lambdaGetAllUsers:
                    # Define an API Gateway endpoint that responds to HTTP GET at /users
                    Type: Api
                    Properties:
                        Path: /api/v1/users
                        Method: GET    

            Policies:
            - DynamoDBCrudPolicy:
                TableName: users
            - DynamoDBCrudPolicy:
                TableName: comments
            - DynamoDBCrudPolicy:
                TableName: books
```

- 3 recursos de tipo Type: 'AWS::DynamoDB::Table' (tablas de DynamoDB). 
Aquí crearemos el nombre de la tabla y algunas características relativas a la performance de la misma.

Un ejemplo de recurso de tabla de DynamoDb sería el siguiente:

```
    usersTable:
        Type: 'AWS::DynamoDB::Table'
        Properties:
            TableName: users
            AttributeDefinitions:
                -   AttributeName: userid
                    AttributeType: S
            KeySchema:
                -   AttributeName: userid
                    KeyType: HASH
            ProvisionedThroughput:
                ReadCapacityUnits: 5
                WriteCapacityUnits: 5
};
```
## Compilación y despliegue

Para construir la aplicación, se ejecutará el siguiente comando:

```
sam build
```

Esto nos creará una estructura de carpetas .aws-sam con todos los recursos del depliegue y los archivos correspondientes.

Para ejecutar la aplicación en local ejecutaremos el siguiente comando:

```
sam local start-api
```

Finalmente para desplegar en AWS ejecutaremos el siguiente comando:

```
sam deploy
```




