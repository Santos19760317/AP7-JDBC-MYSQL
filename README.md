# AP7-JDBC-MYSQL

---

## 🍴 Paso 0: Fork y clonación del repositorio (flujo de trabajo del Aprendiz)

Antes de comenzar a programar, es importante seguir el flujo correcto de trabajo con **GitHub**, tal como se usa en entornos académicos y profesionales.

---

## 🔁 ¿Qué es un Fork?

Un **fork** es una copia del repositorio del instructor que se guarda en tu propia cuenta de GitHub.  
Esto te permite trabajar libremente sin modificar el repositorio original.

📌 **Repositorio del instructor:**  
👉 (https://github.com/astudillodanilo/AP7-JDBC-MYSQL.git)

---

## 🧭 Paso 1: Hacer Fork del repositorio del instructor

1. Ingresa al repositorio del instructor en GitHub
2. En la esquina superior derecha, haz clic en el botón **Fork**
3. Selecciona tu cuenta de GitHub
4. GitHub creará una copia del repositorio en tu perfil

📷 *Ver Video:*

- [Youtube](https://youtu.be/t1Ym6BzTH_M?si=iihOcLZMurOPMkNM)
---

## 💻 Paso 2: Clonar el repositorio en tu computador

Una vez tengas el fork en tu cuenta:

1. Ingresa a **tu repositorio fork**
2. Haz clic en el botón **Code**
3. Copia la URL (HTTPS)

📷 *Ejemplo:*

![Clone](https://docs.github.com/assets/cb-31633/images/help/repository/code-button.png)

4. Abre la terminal (o Git Bash) y ejecuta:

```bash
git clone https://github.com/tu-usuario/nombre-del-repo.git
cd nombre-del-repo
```

# ☕ Java JDBC + MySQL  
## Conexión y CRUD básico (Guía práctica)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-API-blue?style=for-the-badge)

---

## 📌 Descripción del proyecto

Este repositorio tiene como objetivo **enseñar los fundamentos de la conexión entre Java y MySQL usando JDBC**, aplicando los conceptos de **persistencia**, **SQL** y **programación orientada a objetos**.

El proyecto está diseñado como una **guía práctica para estudiantes** que inician en el desarrollo backend con Java.

---

## 🎯 Objetivos de aprendizaje

Al finalizar este proyecto, el estudiante será capaz de:

✅ Comprender qué es JDBC y para qué se utiliza  
✅ Conectarse a una base de datos MySQL desde Java  
✅ Ejecutar sentencias SQL (INSERT, SELECT, UPDATE, DELETE)  
✅ Implementar un CRUD básico usando JDBC  
✅ Aplicar buenas prácticas como `PreparedStatement`  

---

## 🧠 ¿Qué es JDBC?

**JDBC (Java Database Connectivity)** es una API que permite a los programas Java **conectarse y ejecutar operaciones sobre bases de datos relacionales**, independientemente del motor de base de datos.

📘 Conceptos clave:
| Componente | Función |
|-----------|--------|
| `DriverManager` | Obtiene la conexión |
| `Connection` | Representa la conexión activa |
| `PreparedStatement` | Ejecuta SQL parametrizado |
| `ResultSet` | Maneja los resultados |

---

## 🛠️ Requisitos previos

- Java JDK 8 o superior
- MySQL Server - XAMP Maria BD
- IDE (IntelliJ / Eclipse / VS Code)
- Conocimientos básicos de Java

---

## 🗄️ Paso 1: Crear la base de datos y la tabla

```sql
CREATE DATABASE universidad;
USE universidad;

CREATE TABLE estudiantes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  correo VARCHAR(150) NOT NULL
);

```
---

## ⚙️ Paso 2: Agregar driver JDBC (IntelliJ IDEA)


👉 Esta dependencia permite que Java se comunique con MySQL.

---

## 🔌 Paso 3: Importar la Libreria Crear la conexión JDBC

```java
import java.sql.*;

String usuario="root";
        String contra="";
        String url="jdbc:mysql://localhost:3306/universidad"; // 1. Cadena del Driver (JDBC versions)
        Connection cnx;
        Statement st;
        ResultSet rs;

        try {
            // 2. Establish Connection
            cnx = DriverManager.getConnection(url,usuario,contra);
            System.out.println("Connected to database");
            // 3. Create Statement
            st = cnx.createStatement();
            // 4. Execute Query
            //CRUD - INSERT - SELECT - UPDATE - DELETE
            //st.executeUpdate("INSERT INTO ESTUDIANTES(NOMBRE,CORREO) VALUES ('estudiante2','estudiante2@gmail.com')");
            rs=st.executeQuery("SELECT * FROM ESTUDIANTES");
            st.executeUpdate("UPDATE ESTUDIANTES SET NOMBRE='NUEVO_01' WHERE id=8");
            rs=st.executeQuery("SELECT * FROM ESTUDIANTES");
            //st.executeUpdate("DELETE FROM ESTUDIANTES WHERE id=7");
            rs.next();
            // 5. Process Results
            do {
                System.out.println(rs.getInt("id")+" : "+ rs.getString("nombre")+ " "+ rs.getString("correo"));
            }while (rs.next());
            // 6. Close resources
            rs.close();
            st.close();
            cnx.close();
            System.out.println("Disconnected from database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
```
---

