🚀 Mi Primer API REST con Spring Boot

Este proyecto es una API RESTful desarrollada con Spring Boot y MySQL para la gestión de productos, categorías y facturación.
Incluye documentación automática con Swagger / OpenAPI para probar los endpoints desde el navegador.

🛠️ Tecnologías Utilizadas

Java 17+
Spring Boot
Spring Data JPA
MySQL
Maven
Swagger / OpenAPI (springdoc)
IntelliJ IDEA

📂 Base de Datos
La estructura de la base de datos se encuentra en la carpeta:
/sql

Pasos:
Crea un esquema en MySQL llamado:

springboot

Ejecuta el archivo:

bd_backup.sql

⚙️ Configuración

Edita el archivo:

src/main/resources/application.properties

Y coloca tus credenciales:

spring.datasource.url=jdbc:mysql://localhost:3306/springboot
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

▶️ Cómo Ejecutar el Proyecto

Clona el repositorio:

git clone https://github.com/Izayoit/api-rest.git


Entra al proyecto:
cd api-rest

Ejecuta:

mvn spring-boot:run
o desde IntelliJ IDEA presionando ▶️.

📖 Documentación de la API (Swagger)

Una vez que la aplicación esté en ejecución, abre:

👉 http://localhost:8080/swagger-ui.html
o:
👉 http://localhost:8080/swagger-ui/index.html

🔍 Endpoints Principales
📦 Productos

POST /api/v1/producto

PUT /api/v1/producto

GET /api/v1/producto/{id}

DELETE /api/v1/producto/{id}

🧾 Facturas

POST /api/v1/factura

PUT /api/v1/factura

GET /api/v1/factura/{id}

📁 Estructura del Proyecto
src/main/java
 com.ejemplo.api
      controller
      service
      repository
      model

🚧 Mejoras Futuras

Autenticación con JWT

Roles y permisos

Dockerización

Tests unitarios

Validaciones con Bean Validation

Paginación

Versionado de API
