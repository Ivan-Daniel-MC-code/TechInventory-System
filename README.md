# TechInventory System 🚀

**TechInventory** es un sistema integral de gestión de inventarios diseñado con una arquitectura moderna y desacoplada. Este proyecto integra un backend robusto en Spring Boot con un frontend dinámico en Angular.

---

## 🛠️ Stack Tecnológico

### Backend
* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3.x
* **Persistencia:** Spring Data JPA
* **Base de Datos:** SQL Server
* **Seguridad:** Manejo de estados mediante `ResponseEntity`

### Frontend
* **Framework:** Angular 17 (Standalone Components)
* **Lenguaje:** TypeScript
* **Estilos:** Bootstrap 5
* **Comunicación:** RxJS (Observables) y HttpClient

---

## 🏗️ Arquitectura del Proyecto

El proyecto está organizado como un **Monorepo**:

* `/backend`: API RESTful que gestiona la lógica de negocio y la persistencia de datos (Marcas, Categorías, Productos, Proveedores y Usuarios).
* `/frontend`: Aplicación SPA (Single Page Application) que consume los servicios del backend.



---

## 🚀 Cómo ejecutar el proyecto

### 1. Clonar el repositorio
```bash
git clone [https://github.com/Ivan-Daniel-MC-code/TechInventory-System.git](https://github.com/Ivan-Daniel-MC-code/TechInventory-System.git)
