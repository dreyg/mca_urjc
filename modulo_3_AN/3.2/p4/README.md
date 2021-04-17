# Hoja ruta práctica 4: Depuración en contedores / HELM

## Pre-requisitos: Instalación cliente CLI para windows

https://okteto.com/docs/getting-started/installation/index.html

Dos opciones para instalarlo:

- Ejecutar un .exe
- Ejecutar una línea de comandos 

### Instalación del .exe 
- https://downloads.okteto.com/cli/okteto.exe
- Configurar el path

### Instalación de Scoop (cliente de comandos para Windows)
https://scoop.sh/

- Abrir una powerShell como admin
- Cambiar la política de ejecución:

  Set-ExecutionPolicy RemoteSigned -scope CurrentUser

- Lanzar instalación del cliente Scoop

  iwr -useb get.scoop.sh | iex


## Depuración y LiveReload
Podremos hacerlos con dos IDES:

- Spring
- VsCode

Independientemente del IDE en el que lo hagamos, seguiremos estos pasos:

  1. Instalar Okteto CLI (paso anterior)
  2. Desplegamos en Kubernetes (minikube, no hace falta desplegar en okteto):
     (instrucciones en README_P3.md de este mismo directorio)
  3. Creamos el fichero **okteto.yml** si no existe:

    okteto init
  4. Seleccionamos el deploymento sobre el que queremos desarrollar:

    planner-deploy

  5. Si el fichero “okteto.yml” iniciaremos la sincronización usando:

    okteto up        

  6. Para bajarlo, usaremos:

    exit
    okteto down


### Spring: Instalación del LiveReload
http://livereload.com/extensions/

No vamos a ir por ahí....

### VsCode:

Esta parte del video se comienza a comentar en el 1:00 de la clase del viernes 16/04/2021:

  1. Modificar el fichero .vscode/launch.json
    

  



