/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.ConnectionBD;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Angelo Meza
 */
public class ctrlAsignacionRecluso {

    private ConnectionBD connectionBD;
    private static String nombresR = "";
    private static String apellidosR = "";
    private static String idR = "";
    private static String nombreTaller = "";
    private static String nombreGrupo = "";
    private static String idAsignacion = "";

    public ctrlAsignacionRecluso() {
        connectionBD = new ConnectionBD();
    }

    public void datosGlobalesRecluso(String user, String contra) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "Select id_recluso, nombres, apellidos from Reclusos where usuario = ? AND contra = ?";
            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, contra);

            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                this.idR = resultSet.getString("id_recluso");
                this.nombresR = resultSet.getString("Nombres");
                this.apellidosR = resultSet.getString("apellidos");
            }
            System.out.println("Datos de reclusos cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos gloabales para la asignacion de los reclusos: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }

    public void datosGlobalesInscripcion() {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "Select nombre_taller, nombre_grupo from Inscripcion where id_recluso = ?";
            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, idR);

            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                this.nombreTaller = resultSet.getString("nombre_taller");
                this.nombreGrupo = resultSet.getString("nombre_grupo");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos gloabales para la asignacion de los reclusos: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }

    public void cargarAsignacion(JLabel lblTitulo, JLabel lblfecha, JLabel lblCurso, JLabel lblGrupo, JTextArea txtDescripcion) throws SQLException, ClassNotFoundException {
        ConnectionBD connectionBD = new ConnectionBD();

        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "SELECT ID_ASIGNACION, TITULO, CURSO, GRUPO, DESCRIPCION, FECHA_LIMITE FROM ASIGNACION where CURSO = ?  AND GRUPO = ? ";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, nombreTaller);
            statement.setString(2, nombreGrupo);

            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                idAsignacion = resultSet.getString("ID_ASIGNACION");
                lblTitulo.setText(resultSet.getString("TITULO"));
                java.sql.Date fechaLimite = resultSet.getDate("FECHA_LIMITE");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String fechaTexto = dateFormat.format(fechaLimite);
                lblfecha.setText(fechaTexto);
                lblCurso.setText(resultSet.getString("CURSO"));
                lblGrupo.setText(resultSet.getString("GRUPO"));
                txtDescripcion.setText(resultSet.getString("DESCRIPCION"));
            }
            System.out.println("Datos de Asignacion cargados correctamente");

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBD.closeConnection();
        }
    }

    public void guardarDeber(JLabel lblTitulo, JLabel lblFechaLimite, JLabel lblCurso, JLabel lblGrupo, JTextArea txtDescripcion, JTextArea txtRespuesta) throws SQLException, ClassNotFoundException {
        ConnectionBD connectionBD = new ConnectionBD();
        String nuevoId = generarIdAsignacion();
        try {
            connectionBD.openConnection();

            String query = "INSERT INTO Deber (Id_Deber, Id_Asignacion, Titulo, Curso, Grupo, Descripcion, Respuesta, Fecha_Limite, Nombre_Autor, Apellido_Autor, Id_Autor) VALUES (?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'DD-MM-YYYY'), ?, ?, ?)";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nuevoId);
            statement.setString(2, idAsignacion);
            statement.setString(3, lblTitulo.getText());
            statement.setString(4, lblCurso.getText());
            statement.setString(5, lblGrupo.getText());
            statement.setString(6, txtDescripcion.getText());
            statement.setString(7, txtRespuesta.getText());

            try {
                String fechaTexto = lblFechaLimite.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
                Date fechaSql = dateFormat.parse(fechaTexto);
                SimpleDateFormat oracleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String fechaFormateada = oracleDateFormat.format(fechaSql);
                statement.setString(8, fechaFormateada);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            statement.setString(9, nombresR);
            statement.setString(10, apellidosR);
            statement.setString(11, idR);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBD.closeConnection();
        }
    }

    public String generarIdAsignacion() throws ClassNotFoundException, SQLException {
        try {
            connectionBD.openConnection();

            String query = "SELECT MAX(Id_Deber) FROM Deber";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int maxId = 0;
            if (resultSet.next()) {
                String maxIdStr = resultSet.getString(1);
                if (maxIdStr != null) {
                    maxId = Integer.parseInt(maxIdStr.substring(3)); // Extraer el número después del #
                }
            }

            maxId++; // Incrementar el ID
            String nuevoId = String.format("#DR%03d", maxId); // Generar el nuevo ID

            resultSet.close();
            statement.close();

            return nuevoId;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            connectionBD.closeConnection();
        }
    }

    public static Date convertirTextoADate(String fechaTexto) throws ParseException {
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaUtil = formatoFecha.parse(fechaTexto);
        return new Date(fechaUtil.getTime());
    }
}
