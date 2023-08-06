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
public class ctrlAsignacionProfe {

    private ConnectionBD connectionBD;
    private static String id_profesor = "";

    public ctrlAsignacionProfe() {
        connectionBD = new ConnectionBD();
    }

    public void guardarAsignacion(
            JTextField txtTitulo,
            JComboBox<String> cmbCurso,
            JComboBox<String> cmbGrupo,
            JDateChooser jDateFechaAsignacion,
            JTextArea txtDescripcion,
            JLabel lblId
    ) throws SQLException, ClassNotFoundException {
        ConnectionBD connectionBD = new ConnectionBD();

        try {
            connectionBD.openConnection();

            String nuevoId = generarIdAsignacion();

            String query = "INSERT INTO Asignacion (Id_Asignacion, Titulo, Curso, Grupo, Fecha_Limite, Descripcion) VALUES (?, ?, ?, ?, TO_DATE(?, 'dd-MM-yyyy'), ?)";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nuevoId);
            statement.setString(2, txtTitulo.getText());
            statement.setString(3, cmbCurso.getSelectedItem().toString());
            statement.setString(4, cmbGrupo.getSelectedItem().toString());

            Date fechaAsignacion = jDateFechaAsignacion.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String fechaStr = dateFormat.format(fechaAsignacion);
            statement.setString(5, fechaStr);

            statement.setString(6, txtDescripcion.getText());

            statement.executeUpdate();
            statement.close();

            lblId.setText(nuevoId);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBD.closeConnection();
        }
    }

    public String generarIdAsignacion() throws ClassNotFoundException, SQLException {
        try {
            connectionBD.openConnection();

            String query = "SELECT MAX(Id_Asignacion) FROM Asignacion";
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
            String nuevoId = String.format("#AP%03d", maxId); // Generar el nuevo ID

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

    public void guardarDeber(JLabel lblTitulo, JLabel lblFechaLimite, JLabel lblCurso, JLabel lblGrupo, JTextArea txtDescripcion, JTextArea txtRespuesta) throws SQLException, ClassNotFoundException, ParseException {
        ConnectionBD connectionBD = new ConnectionBD();
        String nuevoId = generarIdDeber();

        try {
            connectionBD.openConnection();

            String query = "INSERT INTO TAREAS (ID_DEBER, TITULO, CURSO, GRUPO, DESCRIPCION, RESPUESTA, FECHA_LIMITE) VALUES (?, ?, ?, ?, ?, ?, TO_DATE(?, 'dd-MM-yyyy'))";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nuevoId);
            statement.setString(2, lblTitulo.getText());
            statement.setString(3, lblCurso.getText());
            statement.setString(4, lblGrupo.getText());
            statement.setString(5, txtDescripcion.getText());
            statement.setString(6, txtRespuesta.getText());  // Agregar el contenido del JTextArea txtRespuesta

            String fechaTexto = lblFechaLimite.getText();
            Date fechaSql = convertirTextoADate(fechaTexto);
            statement.setDate(7, new java.sql.Date(fechaSql.getTime()));

            statement.executeUpdate();
            statement.close();

            System.out.println("Deber guardado exitosamente");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBD.closeConnection();
        }
    }

    public String generarIdDeber() throws ClassNotFoundException, SQLException {
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

    public void cargarDeber(String idDeber, JLabel lblTitulo, JLabel lblFecha, JLabel lblCurso, JLabel lblGrupo, JTextArea txtDescripcion, JTextArea txtRespuesta) throws SQLException, ClassNotFoundException {
        ConnectionBD connectionBD = new ConnectionBD();

        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del deber con el ID proporcionado
            String sql = "SELECT TITULO, FECHA_LIMITE, CURSO, GRUPO, DESCRIPCION, RESPUESTA FROM TAREAS WHERE ID_DEBER = ?";

            // Crear la declaración preparada y establecer el parámetro
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, idDeber);

            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y cargar los datos en los componentes de la interfaz
            if (resultSet.next()) {
                lblTitulo.setText(resultSet.getString("TITULO"));
                java.sql.Date fechaLimite = resultSet.getDate("FECHA_LIMITE");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String fechaTexto = dateFormat.format(fechaLimite);
                lblFecha.setText(fechaTexto);
                lblCurso.setText(resultSet.getString("CURSO"));
                lblGrupo.setText(resultSet.getString("GRUPO"));
                txtDescripcion.setText(resultSet.getString("DESCRIPCION"));
                txtRespuesta.setText(resultSet.getString("RESPUESTA"));
            } else {
                System.out.println("No se encontró el deber con ID: " + idDeber);
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBD.closeConnection();
        }
    }

    public static Date convertirTextoADate(String fechaTexto) throws ParseException {
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaUtil = formatoFecha.parse(fechaTexto);
        return new Date(fechaUtil.getTime());
    }

    public void cargarTalleresDocente(JComboBox<String> cmbCurso, String idDocente) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT DISTINCT NOMBRE_ACTIVIDADTALLER FROM ASIGNACIONPROFESOR WHERE ID_DOCENTE = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, idDocente);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombreTaller = resultSet.getString("NOMBRE_ACTIVIDADTALLER");
                cmbCurso.addItem(nombreTaller);
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

    public void cargarGruposDocente(JComboBox<String> cmbGrupo, String idDocente) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT DISTINCT NOMBRE_GRUPO FROM ASIGNACIONPROFESOR WHERE ID_DOCENTE = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, idDocente);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombreGrupo = resultSet.getString("NOMBRE_GRUPO");
                cmbGrupo.addItem(nombreGrupo);
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

    public String getIdProfesor(String usuario) throws ClassNotFoundException, SQLException {
        // Realiza una consulta a la base de datos para obtener el ID del profesor
        String idProfesor = ""; // Inicializa con un valor por defecto

        try {
            connectionBD.openConnection();

            // Consulta para obtener el ID del profesor basado en el nombre de usuario
            String queryIdProfesor = "SELECT id_profesor FROM Profesores WHERE usuario = ?";
            PreparedStatement statementIdProfesor = connectionBD.getConnection().prepareStatement(queryIdProfesor);
            statementIdProfesor.setString(1, usuario);

            ResultSet resultSetIdProfesor = statementIdProfesor.executeQuery();

            if (resultSetIdProfesor.next()) {
                idProfesor = resultSetIdProfesor.getString("id_profesor");

                // Consulta para obtener el ID_DOCENTE basado en el ID del profesor
                String query = "SELECT ID_DOCENTE FROM AsignacionProfesor WHERE ID_DOCENTE = ?";
                PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
                statement.setString(1, idProfesor);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    idProfesor = resultSet.getString("ID_DOCENTE");
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

        return idProfesor;
    }
    // Método para cargar los datos de deberes en los componentes del formulario

   public void cargarDatosDeberes(JLabel lblFechaLimite, JLabel lblCurso, JLabel lblGrupo, JLabel lblTitulo, JTextArea txtDescripcion, JTextArea txtRespuesta,
            JComboBox<String> cmbCurso, JComboBox<String> cmbGrupo, JDateChooser jDateFechaLimite) throws ClassNotFoundException, SQLException {
        try {
            connectionBD.openConnection();

            // Obtener los valores seleccionados en los JComboBox y el JDateChooser
            String cursoSeleccionado = cmbCurso.getSelectedItem().toString().trim();
            String grupoSeleccionado = cmbGrupo.getSelectedItem().toString().trim();
            java.util.Date fechaLimite = jDateFechaLimite.getDate();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
            String fechaLimiteStr = dateFormat.format(fechaLimite).toUpperCase(); // Convertir la fecha a mayúsculas

            // Crear la sentencia SQL para obtener los datos del deber con los parámetros proporcionados
            String sql = "SELECT TITULO, FECHA_LIMITE, CURSO, GRUPO, DESCRIPCION, RESPUESTA FROM DEBER WHERE CURSO = ? AND GRUPO = ? AND FECHA_LIMITE = TO_DATE(?, 'DD-MON-RR')";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, cursoSeleccionado);
            statement.setString(2, grupoSeleccionado);
            statement.setString(3, fechaLimiteStr);

            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y cargar los datos en los componentes del formulario
            if (resultSet.next()) {
                java.sql.Date fechaSQL = resultSet.getDate("FECHA_LIMITE"); // Obtener la fecha directamente en formato Date de la base de datos
                String fechaFormateada = dateFormat.format(fechaSQL); // Formatear la fecha
                lblFechaLimite.setText(fechaFormateada); // Asignar la fecha formateada al JLabel
                lblCurso.setText(resultSet.getString("CURSO"));
                lblGrupo.setText(resultSet.getString("GRUPO"));
                lblTitulo.setText(resultSet.getString("TITULO"));
                txtDescripcion.setText(resultSet.getString("DESCRIPCION"));
                txtRespuesta.setText(resultSet.getString("RESPUESTA"));
            } else {
                lblFechaLimite.setText("");
                lblCurso.setText("");
                lblGrupo.setText("");
                lblTitulo.setText(""); // Limpia el lblTitulo en caso de no encontrar datos
                txtDescripcion.setText("");
                txtRespuesta.setText("");
                JOptionPane.showMessageDialog(null, "No se encontraron datos de deberes.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBD.closeConnection();
        }
    }



}
