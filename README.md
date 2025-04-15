# 📚 Proyecto: CRUD de Libros con Spring Boot y MySQL

## Descripción

Aplicación web que implementa una API REST para la gestión de libros, desarrollada con Spring Boot y MySQL.  
Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una colección de libros almacenada en base de datos.


## 🛠️ Tecnologías Utilizadas

- **Java 21 / Jakarta EE 10**
- **Spring Boot 3.4.4** (Web MVC, Data JPA)
- **MySQL** como base de datos
- **Lombok** para reducir código repetitivo
- **Maven** para la gestión de dependencias



## 📂 Estructura del Proyecto

```
crudspring/
├── src/main/java/com/hellocode/crudspring/
│   ├── controllers/    # API REST endpoints
│   ├── entities/       # Modelos de datos JPA
│   ├── repositories/   # Interfaces para acceso a datos
└── src/main/resources/
    └── application.properties  # Configuración
```


## 📊 Dependencias Principales

```xml
<!-- Spring Web, Data JPA, MySQL, Lombok, DevTools -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```



## 💄 Base de Datos

La aplicación requiere una base de datos MySQL con la siguiente estructura:

```sql
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year INT NOT NULL
);
```

### Configuración en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=root
spring.datasource.password=root
```



## 🌐 API Endpoints

| Método | Endpoint         | Descripción                  |
|--------|------------------|------------------------------|
| GET    | `/libros`        | Listar todos los libros      |
| GET    | `/libros/{id}`   | Obtener libro por ID         |
| POST   | `/libros`        | Crear nuevo libro            |
| PUT    | `/libros/{id}`   | Actualizar libro existente   |
| DELETE | `/libros/{id}`   | Eliminar libro               |



## 📝 Ejemplos de Uso

### Obtener todos los libros

```http
GET http://localhost:8080/libros
```

### Crear un nuevo libro

```http
POST http://localhost:8080/libros
Content-Type: application/json

{
  "title": "El Señor de los Anillos",
  "author": "J.R.R. Tolkien",
  "year": 1954
}
```

### Actualizar un libro

```http
PUT http://localhost:8080/libros/1
Content-Type: application/json

{
  "title": "Don Quijote de la Mancha (Edición revisada)",
  "author": "Miguel de Cervantes",
  "year": 1605
}
```

### Eliminar un libro

```http
DELETE http://localhost:8080/libros/1
```

**Respuesta:**
```
> El libro con el ID: 1 fue eliminado correctamente.
```

---

## 📊 Modelo de Datos

```java
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;         // Identificador único

    private String title;    // Título del libro
    private String author;   // Autor del libro
    private Integer year;    // Año de publicación
}
```


## 👨‍💻 Autor

**Jefferson David Cano**

