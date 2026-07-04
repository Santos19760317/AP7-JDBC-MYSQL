import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // Variables de conexión
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/ap7-jdbc";

        // Objetos JDBC
        Connection cnx = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 1. Establecer conexión
            cnx = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectado correctamente a la base de datos.");

            // 2. Crear Statement
            st = cnx.createStatement();

            // =========================
            // INSERT
            // =========================
            st.executeUpdate("INSERT INTO estudiantes(nombres, correo) VALUES ('PEPITO', 'CORREO@GMAIL.COM')");
            System.out.println("Registro insertado correctamente.");

            // =========================
            // SELECT INICIAL
            // =========================
            rs = st.executeQuery("SELECT * FROM estudiantes");

            System.out.println("\nListado inicial de estudiantes:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("nombres") + " | " +
                                rs.getString("correo")
                );
            }

            // Cerrar el ResultSet antes de hacer otra consulta
            rs.close();

            // =========================
            // UPDATE
            // =========================
            int filasActualizadas = st.executeUpdate(
                    "UPDATE estudiantes SET nombres='PEPITO ACTUALIZADO' WHERE nombres='PEPITO'"
            );
            System.out.println("\nRegistros actualizados: " + filasActualizadas);

            // =========================
            // DELETE
            // =========================
            int filasEliminadas = st.executeUpdate(
                    "DELETE FROM estudiantes WHERE nombres='PEPITO ACTUALIZADO'"
            );
            System.out.println("Registros eliminados: " + filasEliminadas);

            // =========================
            // SELECT FINAL
            // =========================
            rs = st.executeQuery("SELECT * FROM estudiantes");

            System.out.println("\nListado final de estudiantes:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("nombres") + " | " +
                                rs.getString("correo")
                );
            }

            // 6. Cerrar recursos
            rs.close();
            st.close();
            cnx.close();

            System.out.println("\nDesconexión realizada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error en la conexión o en la consulta: " + e.getMessage());
        }
    }
}