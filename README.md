# AutomatizacionApiRestassured
Proyecto: Automatización de API REST con Rest Assured
=======================================================

### 🧪 Descripción
Este proyecto automatiza pruebas sobre la API pública [ReqRes](https://reqres.in/) utilizando Java, Rest Assured, TestNG y Allure para reportería. Se valida el correcto funcionamiento de endpoints típicos como GET, POST, PUT y DELETE.

---

### 📁 Estructura del proyecto
```
automatizacionApiRestAssured/
├── pom.xml
├── testng.xml
├── /src
│   └── /test
│       ├── /java
│       │   └── tests
│       │       ├── GetUsersTest.java
│       │       ├── CreateUserTest.java
│       │       ├── UpdateUserTest.java
│       │       └── DeleteUserTest.java
│       └── /resources
└── /allure-results
```

---

### ⚙️ Tecnologías utilizadas
- Java 11+
- Maven
- Rest Assured
- TestNG
- Allure Framework

---

### ✅ Casos de prueba implementados
| ID     | Descripción                                           | Tipo     |
|--------|--------------------------------------------------------|----------|
| TC01   | Obtener lista de usuarios (GET)                       | Positiva |
| TC02   | Obtener usuario inexistente (GET 404)                | Negativa |
| TC03   | Crear un nuevo usuario (POST)                         | Positiva |
| TC04   | Actualizar usuario existente (PUT)                   | Positiva |
| TC05   | Eliminar usuario (DELETE)                            | Positiva |
| TC06   | Validar tiempo de respuesta inferior a 2 segundos    | Performance |
| TC07   | Validar respuesta contra JSON Schema (GET)           | Contract |

---

### 🧰 Configuración y ejecución
1. Clona el repositorio
```bash
git clone https://github.com/RicardoVasq/automatizacionApiRestAssured.git
```

2. Ejecuta los tests
```bash
mvn clean test
```

3. Genera el reporte Allure
```bash
allure serve allure-results
```

---

### 📊 Reporterías
Allure se genera automáticamente en la carpeta `/allure-results` y muestra:
- Casos pasados/fallidos
- Detalles de cada prueba
- Adjuntos como logs o tiempos

---

### 🧠 Mejores prácticas implementadas
- Separación por clases de prueba
- Validaciones completas del body y status code
- Uso de assertions claras
- Validación de contratos con JSON Schema (opcional)
- Reportería integrada con Allure

---

### 🚀 Futuras mejoras
- Agregar pruebas con autenticación (token)
- Cargar datos desde archivo JSON
- Integración con GitHub Actions

---

> Desarrollado por Ricardo Vásquez ✨
