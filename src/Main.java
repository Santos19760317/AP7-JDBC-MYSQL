import java.sql.*;

// Escribir la libreira;  // importar la libreria
public class Main {
    public static void main(String[] args) {
        // Declarar las Variables de conexión


        // 1. Load Driver (Optional for newer JDBC versions)


        try { // Manejo de Errores Try catch
            // 2. Establecer la conexión e Imprimir

            // 3. Create Statement

            // 4. Execute Query
            //CRUD - INSERT - SELECT - UPDATE - DELETE

            // 5. Process Results
            //do {
            //    System.out.println(rs.getInt("id")+" : "+ rs.getString("nombre")+ " "+ rs.getString("correo"));
            //}while (rs.next());
            // 6. Close resources
            // Cerrar el Resultado de la Consulta
            // Cerra el statement
            // Cerrar la conexion a la base de datos e Imprimir

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

