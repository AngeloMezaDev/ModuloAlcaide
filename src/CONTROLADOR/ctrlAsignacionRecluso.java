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
import javax.swing.JOptionPane;
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
    private static String deber = "";
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
    public void cargarTalleresRecluso(JComboBox<String> cmbTallerAsistencias, String idRecluso) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT DISTINCT NOMBRE_TALLER FROM INSCRIPCION WHERE ID_RECLUSO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, idRecluso);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombreTaller = resultSet.getString("NOMBRE_TALLER");
                cmbTallerAsistencias.addItem(nombreTaller);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar talleres: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
    }
    public void cargarGruposRecluso(JComboBox<String> cmbGrupoAsistencias, String idRecluso) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT DISTINCT NOMBRE_GRUPO FROM INSCRIPCION WHERE ID_RECLUSO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, idRecluso);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombreGrupo = resultSet.getString("NOMBRE_GRUPO");
                cmbGrupoAsistencias.addItem(nombreGrupo);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar grupos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
    }
    public void cargarTareasRecluso(JComboBox<String> cmbTareas, String nombreTaller, String nombreGrupo) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT TITULO FROM ASIGNACION WHERE CURSO = ? AND GRUPO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nombreTaller);
            System.out.println("NombreTaller: " +  nombreTaller);
            statement.setString(2, nombreGrupo);
            System.out.println("GRUPO: " + nombreGrupo);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String tareas = resultSet.getString("TITULO");
                System.out.println("TITULO: " + tareas);
                cmbTareas.addItem(tareas);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar talleres: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
    }
    public String getIdRecluso(String usuario) throws ClassNotFoundException, SQLException {
        // Realiza una consulta a la base de datos para obtener el ID del profesor
        String idRecluso = ""; // Inicializa con un valor por defecto

        try {
            connectionBD.openConnection();

            // Consulta para obtener el ID del profesor basado en el nombre de usuario
            String queryIdProfesor = "SELECT id_recluso FROM Reclusos WHERE usuario = ?";
            PreparedStatement statementIdProfesor = connectionBD.getConnection().prepareStatement(queryIdProfesor);
            statementIdProfesor.setString(1, usuario);

            ResultSet resultSetIdProfesor = statementIdProfesor.executeQuery();

            if (resultSetIdProfesor.next()) {
                idRecluso = resultSetIdProfesor.getString("id_recluso");

                // Consulta para obtener el ID_DOCENTE basado en el ID del profesor
                String query = "SELECT ID_RECLUSO FROM AsignacionRecluso WHERE ID_RECLUSO = ?";
                PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
                statement.setString(1, idRecluso);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    idRecluso = resultSet.getString("ID_RECLUSO");
                }

                resultSet.close();
                statement.close();
            }

            resultSetIdProfesor.close();
            statementIdProfesor.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de la excepción
        } finally {
            connectionBD.closeConnection();
        }

        return idRecluso;
    }

    public void CargarDatosTalleres(String user, String contra, JLabel Taller, JLabel Grupo, JLabel TiempoReduccion, JLabel FechaInicio, JLabel FechaFin, String NombreTaller, String NombreCurso) throws ClassNotFoundException, SQLException {
        ConnectionBD connectionBD = new ConnectionBD();
        datosGlobalesRecluso(user, contra);
        datosGlobalesInscripcion();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "SELECT * FROM INSCRIPCION where NOMBRE_TALLER = ?  AND NOMBRE_GRUPO = ? ";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, NombreTaller);
            statement.setString(2, NombreCurso);

            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                Taller.setText(resultSet.getString("NOMBRE_TALLER"));
                Grupo.setText(resultSet.getString("NOMBRE_GRUPO"));
                TiempoReduccion.setText(resultSet.getString("REDUCCION_CONDENA"));
                FechaInicio.setText(resultSet.getString("FECHA_CREACION"));
                FechaFin.setText(resultSet.getString("FECHA_VENCIMIENTO"));
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
        String nuevoId = generarIdDeber();
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

    public String generarIdDeber() throws ClassNotFoundException, SQLException {
        String nuevoId="";
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
             nuevoId = String.format("#DR%03d", maxId); // Generar el nuevo ID

            resultSet.close();
            statement.close();
            System.out.println("ID DEBER: "+nuevoId);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            connectionBD.closeConnection();
        }
        return nuevoId;
    }

    public static Date convertirTextoADate(String fechaTexto) throws ParseException {
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaUtil = formatoFecha.parse(fechaTexto);
        return new Date(fechaUtil.getTime());
    }

    public void cargarAsignacion(String usuario, String contrasena, JLabel lblTitulo, JLabel lblFechaLimite, JLabel lblCurso, JLabel lblGrupo, JTextArea txtDescripcion, String NombreTaller, String NombreCurso) throws ClassNotFoundException, SQLException {
        datosGlobalesInscripcion();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "SELECT TITULO, FECHA_LIMITE, CURSO, GRUPO, DESCRIPCION FROM ASIGNACION where CURSO = ?  AND GRUPO = ? ";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, NombreTaller);
            statement.setString(2, NombreCurso);

            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                        lblTitulo.setText(resultSet.getString("TITULO"));
                        lblFechaLimite.setText(resultSet.getString("FECHA_LIMITE"));
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

    public String NombreDocente(String nombreTaller, String nombreCurso) throws ClassNotFoundException, SQLException {
       String nombreDocente = "";
        try {
            connectionBD.openConnection();

            String query = "SELECT NOMBRE_DOCENTE FROM ASIGNACIONPROFESOR WHERE NOMBRE_ACTIVIDADTALLER = ? AND NOMBRE_GRUPO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nombreTaller);
            statement.setString(2, nombreCurso);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nombreDocente = resultSet.getString("NOMBRE_DOCENTE");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar nombre del docente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
        return nombreDocente;
    }

    public String NombreTarea(String nombreTaller, String nombreCurso) throws ClassNotFoundException, SQLException {
        String nombreTarea = "";
        try {
            connectionBD.openConnection();

            String query = "SELECT TITULO FROM DEBER WHERE CURSO = ? AND GRUPO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nombreTaller);
            statement.setString(2, nombreCurso);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombreDocente = resultSet.getString("TITULO");
                return nombreDocente;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar nombre de la tarea: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
        return nombreTarea;
    }
    public boolean VerificarDeberEnviado(String ID_Autor) throws SQLException, ClassNotFoundException{
        boolean resultado = false;
        try {
            connectionBD.openConnection();

            String query = "SELECT * FROM DEBER WHERE Id_Autor = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, ID_Autor);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Si el resultado tiene al menos una fila, el deber ha sido enviado
                resultado =  true;
            } else {
                // Si no se encontró ninguna fila, el deber no ha sido enviado
                resultado = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar nombre de la tarea: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
        return resultado;
    }

    public String ObtenerIdRecluso(String usuario, String contrasena) throws ClassNotFoundException, SQLException {
        String IdRecluso = "";
        try {
            connectionBD.openConnection();

            String query = "SELECT ID_RECLUSO FROM RECLUSOS WHERE USUARIO = ? AND CONTRA = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                IdRecluso = resultSet.getString("ID_RECLUSO");
                
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar el id del recluso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
        return IdRecluso;
    }

    public String ObtenerIdDeber(String IdRecluso) throws SQLException, ClassNotFoundException {
        String IdTarea = "";
        try {
            connectionBD.openConnection();

            String query = "SELECT ID_DEBER FROM DEBER WHERE ID_AUTOR = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, IdRecluso);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                IdTarea = resultSet.getString("ID_DEBER");
                
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar el id de la tarea: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connectionBD.closeConnection();
        }
        return IdRecluso;

    }
}
