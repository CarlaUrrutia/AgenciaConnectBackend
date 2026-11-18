# AgenciaConnect API

API REST desarrollada con Spring Boot para la gestión de una agencia CRM. Permite administrar contactos, organizaciones, oportunidades, eventos, seguimientos y usuarios.

---

## 👥 Integrantes

- Benjamín Parra
- Carla Urrutia

---

## 📋 Descripción

AgenciaConnect es un sistema de gestión de relaciones con clientes (CRM) orientado a agencias. Provee una API REST que permite registrar y gestionar contactos, organizaciones, oportunidades de negocio, eventos, seguimientos y usuarios del sistema.

---

## ✅ Funcionalidades

- Gestión de **contactos** (crear, listar, actualizar)
- Gestión de **organizaciones** (crear, listar, actualizar)
- Gestión de **oportunidades** de negocio (crear, listar, actualizar)
- Gestión de **eventos** (crear, listar, actualizar)
- Registro de **seguimientos** por oportunidad (crear, listar, eliminar)
- Gestión de **usuarios** con autenticación por login
- Inicialización automática de datos de prueba al arrancar
- Creación automática de la base de datos si no existe

---

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas estándar de Spring Boot:

```
src/
└── main/
    └── java/cl/duoc/agenciaconnectapi/
        ├── config/        → Inicialización de datos (DataInitializer)
        ├── controller/    → Endpoints REST (reciben y responden peticiones HTTP)
        ├── model/         → Entidades JPA mapeadas a la base de datos
        ├── repository/    → Interfaces de acceso a datos (Spring Data JPA)
        └── service/       → Lógica de negocio
```

**Entidades del modelo:**
- `Usuario` — usuarios del sistema (ejecutivos, etc.)
- `Contacto` — personas de contacto
- `Organizacion` — empresas u organizaciones
- `Oportunidad` — oportunidades de negocio
- `Evento` — eventos asociados
- `Seguimiento` — seguimientos por oportunidad

---

## 🛠️ Tecnologías

| Tecnología | Versión |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.1.2 |
| Spring Data JPA | - |
| MySQL | - |
| Lombok | - |
| Maven | - |

---

## ⚙️ Requisitos previos

- Java 21
- XAMPP con MySQL activo
- IntelliJ IDEA (recomendado)
- Maven

---

## 🚀 Instrucciones de ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/CarlaUrrutia/AgenciaConnectBackend.git
   ```

2. **Abre el proyecto en IntelliJ IDEA**

3. **Inicia XAMPP** y activa el módulo **MySQL**

4. **Ejecuta la aplicación** desde IntelliJ — la base de datos `bd_agenciaconnect` se crea automáticamente

5. La API estará disponible en:
   ```
   http://localhost:8080
   ```

> La contraseña de MySQL por defecto es vacía (configuración estándar de XAMPP). Si tu instalación tiene contraseña, edita `src/main/resources/application.properties`.

---

## 🔗 Endpoints

### Contactos — `/api/contactos`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/contactos` | Listar todos |
| GET | `/api/contactos/{id}` | Obtener por ID |
| POST | `/api/contactos` | Crear |
| PUT | `/api/contactos/{id}` | Actualizar |

### Organizaciones — `/api/organizaciones`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/organizaciones` | Listar todas |
| GET | `/api/organizaciones/{id}` | Obtener por ID |
| POST | `/api/organizaciones` | Crear |
| PUT | `/api/organizaciones/{id}` | Actualizar |

### Oportunidades — `/api/oportunidades`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/oportunidades` | Listar todas |
| GET | `/api/oportunidades/{id}` | Obtener por ID |
| POST | `/api/oportunidades` | Crear |
| PUT | `/api/oportunidades/{id}` | Actualizar |

### Eventos — `/api/eventos`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/eventos` | Listar todos |
| GET | `/api/eventos/{id}` | Obtener por ID |
| POST | `/api/eventos` | Crear |
| PUT | `/api/eventos/{id}` | Actualizar |

### Seguimientos — `/api/seguimientos`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/seguimientos` | Listar todos |
| GET | `/api/seguimientos/oportunidad/{oportunidadId}` | Por oportunidad |
| POST | `/api/seguimientos` | Crear |
| DELETE | `/api/seguimientos/{id}` | Eliminar |

### Usuarios — `/api/usuarios`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/usuarios` | Listar todos |
| GET | `/api/usuarios/ejecutivos` | Listar ejecutivos |
| GET | `/api/usuarios/{id}` | Obtener por ID |
| POST | `/api/usuarios/login` | Iniciar sesión |
