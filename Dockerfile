# Imagen base con Java
FROM eclipse-temurin:17-jdk-alpine

# Carpeta dentro del contenedor
WORKDIR /app

# Copiar el jar generado por Maven
COPY target/app_reservas-api-0.0.1-SNAPSHOT.jar app.jar

# Puerto que usa Spring Boot
EXPOSE 8080

# Ejecutar aplicación
ENTRYPOINT ["java","-jar","app.jar"]