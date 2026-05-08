# 🏨 Hotel — Gestión de Habitaciones y Reservas

> **Práctica UT8-RA9 · C.F.G.S DAW · Programación**
> Alumno: **Engel Nieves**

Aplicación web desarrollada con **Spring Boot, JPA/Hibernate, Thymeleaf y MySQL** que
gestiona las habitaciones y reservas de un hotel.

🌐 **Demo en producción:** [https://hoteles-production-0bf1.up.railway.app](https://hoteles-production-0bf1.up.railway.app)

---

## 📋 Descripción del proyecto

La aplicación permite:
- Ver el **listado de habitaciones** (Simple, Doble, Suite, Familiar) con precio por noche,
  capacidad y disponibilidad.
- Ver el **listado de reservas** vinculadas a sus habitaciones.
- **Dar de alta** nuevas habitaciones y reservas mediante formularios validados.
- Al arrancar, carga automáticamente **12 habitaciones** y **12 reservas** de ejemplo.

---

## ✅ Requisitos previos

| Herramienta       | Versión mínima |
|-------------------|---------------|
| Java (JDK)        | 17            |
| Maven             | 3.8+          |
| MySQL Server      | 8.0+          |
| Spring Boot       | 3.2.5         |

---

## 🚀 Pasos para ejecutarlo en local

### 1 · Clonar el repositorio

```bash
git clone https://github.com/Enngel/Hoteles.git
cd Hoteles
```

### 2 · Ejecutar el script SQL

Conéctate a tu servidor MySQL como root y ejecuta el script:

```bash
mysql -u root -p < schema.sql
```

Esto creará la base de datos `hotel_db` con las tablas necesarias.

### 3 · Configurar `application.properties`

Abre `src/main/resources/application.properties` y ajusta las credenciales de tu entorno local:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña
```

### 4 · Ejecutar la aplicación

```bash
mvn spring-boot:run
```

Abre el navegador en: **http://localhost:8080/inicio**

---

## 🌐 Despliegue en Railway

La aplicación está desplegada y accesible en:

👉 **https://hoteles-production-0bf1.up.railway.app**

---

## 🗂️ Estructura del proyecto

```
Hoteles/
├── schema.sql                     # Script de creación de la BD
├── system.properties              # Java 17 para Railway
├── pom.xml
└── src/main/
    ├── java/com/engelnieves/hotel/
    │   ├── HotelApplication.java  # Clase principal
    │   ├── DataLoader.java        # CommandLineRunner (datos iniciales)
    │   ├── model/
    │   │   ├── Habitacion.java    # Entidad JPA
    │   │   └── Reserva.java       # Entidad JPA
    │   ├── repository/
    │   │   ├── HabitacionRepository.java
    │   │   └── ReservaRepository.java
    │   └── controller/
    │       └── HotelController.java
    └── resources/
        ├── application.properties
        └── templates/
            ├── inicio.html
            ├── listadoHabitacion.html
            ├── listadoReserva.html
            ├── altaHabitacion.html
            ├── altaReserva.html
            └── error.html
```

---

## 🔗 Endpoints

| Método | URL                   | Descripción                      |
|--------|-----------------------|----------------------------------|
| GET    | `/inicio`             | Página principal                 |
| GET    | `/listadoHabitacion`  | Listado de habitaciones          |
| GET    | `/listadoReserva`     | Listado de reservas              |
| GET    | `/altaHabitacion`     | Formulario de alta de habitación |
| POST   | `/altaHabitacion`     | Guardar nueva habitación         |
| GET    | `/altaReserva`        | Formulario de alta de reserva    |
| POST   | `/altaReserva`        | Guardar nueva reserva            |

---

## 🛠 Tecnologías utilizadas

- **Spring Boot 3.2.5**
- **Spring Data JPA / Hibernate**
- **Thymeleaf** con **Bootstrap 5.3**
- **MySQL 8**
- **Maven**
- **Railway** (despliegue en la nube)
