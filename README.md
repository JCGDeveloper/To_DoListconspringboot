# Portfolio


Gestor de Tareas por Equipos



Este es un sistema de gestión de tareas que permite organizar tareas por equipos, asignar prioridades y usuarios, y realizar un seguimiento del progreso.



Características



✅ Crear, editar y eliminar tareas

✅ Asignar tareas a usuarios específicos

✅ Establecer prioridades de tareas

✅ Listar tareas pendientes y completadas

✅ API REST para interactuar con el backend



Tecnologías utilizadas



🔹 Backend: Java, Spring Boot JPA, Hibernate

🔹 Frontend: HTML, CSS, JavaScript 

🔹 Base de datos: MySQL

🔹 API: REST con JSON



Endpoints principales



Tareas

• GET /tasks → Obtener todas las tareas

• POST /tasks → Crear una nueva tarea

• PUT /tasks/{id} → Editar una tarea

• DELETE /tasks/{id} → Eliminar una tarea

• PUT /tasks/{id}/assign → Asignar un usuario a una tarea



Usuarios

• GET /users → Listar usuarios

• POST /users → Crear un usuario



Instalación y configuración



1. Clonar el repositorio

2. Configurar el backend

1. Instalar Java 17+ y Maven

2. Configurar application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/tareas_db
spring.datasource.username=root
spring.datasource.password=tu_contraseña
3. Ejecutar el backend:

mvn spring-boot:run
3. Configurar el frontend



Si tienes un frontend separado:

cd frontend
npm install
npm run dev
Mejoras futuras



🚀 Notificaciones en tiempo real con WebSockets

🚀 Interfaz gráfica más avanzada

🚀 Integración con herramientas como Slack o Trello

Actualiza el README con lo que ya tengas implementado. ¿Quieres que agreguemos algo más?
