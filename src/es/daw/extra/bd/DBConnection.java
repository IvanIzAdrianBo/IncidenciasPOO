package es.daw.extra.bd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection con = null;

    private DBConnection() {
    }

    /**
     * Método para obtener la conexión
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        if (con == null) {

            Properties props = new Properties();
            String dbSettingsPropsFilePath = System.getProperty("user.home") + File.separator + "JDBC.properties";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                FileReader fReader = new FileReader(dbSettingsPropsFilePath);
                props.load(fReader);
                con = DriverManager.getConnection(props.getProperty("url"), props);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                throw new SQLException("No se ha encontrado el fichero de propiedades");
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new SQLException("Error cargando el fichero de propiedades");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                throw new SQLException("No se ha encontrado el driver de conexión");
            }
        }
        return con;
    }

    /**
     * Método para cerrar la conexión
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
