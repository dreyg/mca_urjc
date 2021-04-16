# Selecciona la imagen base
FROM node:lts-alpine

# Especificamos esta variable para la correcta ejecución de las librerías en modo de producción
ENV NODE_ENV production

# Definimos el directorio de trabajo en /usr/src/app/
WORKDIR /usr/server/


# Descargamos el script wait-for-it.sh
RUN apk add --no-cache curl
RUN apk add --no-cache bash
RUN rm -rf /var/lib/apt/lists/*
RUN curl -LJO https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh
# Descargamos el script wait-for-it.sh
RUN chmod +x /usr/server/wait-for-it.sh

# Copiamos los ficheros de la aplicación
COPY ./config /usr/server/config/
COPY ./public /usr/server/public/
COPY ./src /usr/server/src/
COPY package.json /usr/server/

# Instalamos las dependencias que necesita la app
RUN npm install --only=production

# Indica el puerto que expone el contenedor
EXPOSE 3000

# Comando que se ejecuta cuando se arranque el contenedor
CMD ["node", "src/server.js"]

