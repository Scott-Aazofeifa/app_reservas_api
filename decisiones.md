# Decisiones de Diseño


Se utilizó una arquitectura en capas:

- Controller
- Service
- Repository
- Entity

Esto permite separar responsabilidades y mantener el código organizado.

## Base de Datos

Se utilizó PostgreSQL como base de datos relacional.

## ORM

Se utilizó Hibernate mediante Spring Data JPA para facilitar el acceso a la base de datos y evitar escribir SQL manual.

## Validaciones

Las reservas tienen validaciones de negocio:

- La duración máxima es de 2 horas
- No se permiten reservas en horarios solapados
- Las reservas pueden cancelarse

## Contenerización
Se utilizó Docker para facilitar la ejecución del proyecto en cualquier entorno sin depender de configuraciones locales.
