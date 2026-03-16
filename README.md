# Sistema de Reservas API

API REST desarrollada con **Spring Boot** para gestionar reservas de recursos.

## Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Maven

## Entidades

- Usuario
- Recurso
- Reserva

## Endpoints

### Usuarios
GET /usuarios
GET /usuarios/{id}
POST /usuarios  
PUT /usuarios/{id}
DELETE /usuarios/{id}

### Recursos
GET /recursos
GET /recursos/{id}
POST /recursos  
PUT /recursos/{id}
DELETE /recursos/{id} 

### Reservas
GET /reservas  
GET /reservas/{id}  
POST /reservas  
PUT /reservas/{id}/cancelar  

## Ejecutar proyecto

### Con Maven
