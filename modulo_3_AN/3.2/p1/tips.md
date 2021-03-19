## COMANDOS ÚTILES GESTIÓN CONTENEDORES 

- Ejecución de contenedores:
  docker run "nombre de contenedor":"tag"
    * Ejemplo:
      'docker run hello-world'

  * Ejemplo con tag:
    'docker run hello-world:linux'

    docker run --name static-site \
    -e AUTHOR="Your Name" -d \
    -p 9000:80 seqvence/static-site
    
    --name nombre del contenedor

- Inspeccionar contenedores existentes:
  'docker ps -a'
  
- Listar imágenes descargadas
  'docker image ls'
