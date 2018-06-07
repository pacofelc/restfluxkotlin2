# restfluxkotlin2
Prueba de concepto REST Spring Boot Flux Kotlin Mongodb

#Configuración

Crear un contenedor con Mongo para la persistencia
docker run -p 27017:27017 --name mi-mongo -d mongo:3.6.5

# Crear un nuevo registro
http://localhost:8080/student/new?id=3&name=maria

# Recuperar todos los registros
http://localhost:8080/students

