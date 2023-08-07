/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.AsignacionRecluso;
import MODELO.AsignacionProfesor;
import MODELO.ConnectionBD;
import MODELO.Recluso;
import MODELO.Profesor;
import VISTAS.frmPerfilProfesor;
import VISTAS.frmProfesores;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import java.awt.Color;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yordan
 */
public class ctrlProfesores {

    private ConnectionBD connectionBD;
    private static String id_profesor = "";
    private static String id_Asignacion = "";

    public ctrlProfesores() {
        connectionBD = new ConnectionBD();
    }

    public void cargarDatosProfesor(JLabel lblId, String usuario, String contra, JLabel lblApellidos, JLabel lblNombres, JLabel lblCedula, JLabel lblAñosExperiencia, JLabel lblEspecialidad, JLabel lblCorreo, JLabel lbledad, JLabel lblFechaNacs) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "SELECT id_profesor, cedula, apellidos, nombres, experiencia, especialidad, correo, fecha_nacimiento FROM Profesores where usuario = ? AND contra = ?";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contra);

            ResultSet resultSet = statement.executeQuery();
            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                lblId.setText(resultSet.getString("id_Profesor"));
                lblCedula.setText(resultSet.getString("cedula"));
                lblApellidos.setText(resultSet.getString("apellidos"));
                lblNombres.setText(resultSet.getString("nombres"));
                lblAñosExperiencia.setText(resultSet.getString("experiencia") + " años");
                lblEspecialidad.setText(resultSet.getString("especialidad"));
                lblCorreo.setText(resultSet.getString("correo"));
                lblFechaNacs.setText(obtenerSoloFecha(resultSet.getString("fecha_nacimiento")));
                lbledad.setText(calcularEdad(resultSet.getString("fecha_nacimiento")) + " años");

                Date fechaNac = null;
                try {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    fechaNac = formatoFecha.parse(lblFechaNacs.getText());
                } catch (ParseException e) {
                    System.err.println("Error al convertir la fecha: " + e.getMessage());
                }
            }
            System.out.println("Datos del docente cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos de los reclusos: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void cargarDatosProfe(JLabel lblId, String usuario, String contra, JTextField lblApellidos, JTextField lblNombres, JTextField lblCedula, JTextField lblCorreo, JDateChooser lblFechaNacs) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del profesor con el usuario y contraseña proporcionados
            String sql = "SELECT id_profesor, cedula, apellidos, nombres, correo, fecha_nacimiento FROM Profesores WHERE usuario = ? AND contra = ?";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contra);

            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontraron resultados y si es así, cargar los datos en los campos de la interfaz
            if (resultSet.next()) {
                id_profesor = resultSet.getString("id_profesor");
                lblId.setText(id_profesor);
                lblCedula.setText(resultSet.getString("cedula"));
                lblApellidos.setText(resultSet.getString("apellidos"));
                lblNombres.setText(resultSet.getString("nombres"));
                lblCorreo.setText(resultSet.getString("correo"));
                lblFechaNacs.setDate(resultSet.getDate("fecha_nacimiento"));

                System.out.println("Datos del profesor cargados correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del profesor: " + e.getMessage(), "Error de consulta", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void cargarDatosTalleres(JCalendar cldAgenda) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL 
            String sql = "SELECT r.id_recluso, r.nombres || ' ' || r.apellidos AS nombre_recluso, a.tipo_asignacion, CASE WHEN a.tipo_asignacion = 'Actividad' THEN"
                    + " act.fecha_hora_actividad  WHEN a.tipo_asignacion = 'Taller' THEN TO_CHAR(t.FECHA_CREACION, 'YYYY-MM-DD HH24:MI:SS')"
                    + " ELSE NULL END AS fecha_asignacion FROM Reclusos r"
                    + " JOIN AsignacionRecluso a ON r.id_recluso = a.id_recluso"
                    + " LEFT JOIN actividades act ON a.Id_ActividadTaller = act.id_actividad"
                    + " LEFT JOIN TalleresAlcaide t ON a.Id_ActividadTaller = t.ID_TALLER"
                    + " WHERE r.id_recluso = ?";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, id_profesor);
            ResultSet resultSet = statement.executeQuery();
            // Recorrer el resultado           
            while (resultSet.next()) {
                String fechaCreacion = resultSet.getString("fecha_asignacion");
                // Setear el JCalendar con la fecha de creación
                cldAgenda.setDate(fecha(fechaCreacion));

            }
            System.out.println("Datos de talleres cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos de los talleres: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public Date cargarFecha() {
        String fechaCreacion = "";
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL 
            String sql = "SELECT r.id_recluso, r.nombres || ' ' || r.apellidos AS nombre_recluso, a.tipo_asignacion, CASE WHEN a.tipo_asignacion = 'Actividad' THEN"
                    + " act.fecha_hora_actividad  WHEN a.tipo_asignacion = 'Taller' THEN TO_CHAR(t.FECHA_CREACION, 'YYYY-MM-DD HH24:MI:SS')"
                    + " ELSE NULL END AS fecha_asignacion FROM Reclusos r"
                    + " JOIN AsignacionRecluso a ON r.id_recluso = a.id_recluso"
                    + " LEFT JOIN actividades act ON a.Id_ActividadTaller = act.id_actividad"
                    + " LEFT JOIN TalleresAlcaide t ON a.Id_ActividadTaller = t.ID_TALLER"
                    + " WHERE r.id_recluso = ?";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, id_profesor);
            ResultSet resultSet = statement.executeQuery();
            // Recorrer el resultado           
            while (resultSet.next()) {
                fechaCreacion = resultSet.getString("fecha_asignacion");
                // Setear el JCalendar con la fecha de creación

            }
            System.out.println("Datos de talleres cargados correctamente.");

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos de los talleres: " + e.getMessage());

        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return fecha(fechaCreacion);
    }

// Método para calcular la edad a partir de la fecha de nacimiento
    public String calcularEdad(String fechaNacimiento) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = sdf.parse(fechaNacimiento);
            Date fechaActual = new Date();
            long tiempoNac = fechaNac.getTime();
            long tiempoActual = fechaActual.getTime();
            long diferencia = tiempoActual - tiempoNac;

            Calendar edad = Calendar.getInstance();
            edad.setTimeInMillis(diferencia);

            int edadAnios = edad.get(Calendar.YEAR) - 1970;

            // Convertir la edad a una cadena y retornarla
            return String.valueOf(edadAnios);
        } catch (ParseException e) {
            e.printStackTrace();
            return "Error al convertir la fecha de nacimiento a edad";
        }

    }

    public String obtenerSoloFecha(String fechaNac) {
        try {
            SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateTime = sdfDateTime.parse(fechaNac);

            // Formato para solo la fecha
            SimpleDateFormat sdfFecha = new SimpleDateFormat("yyyy-MM-dd");
            return sdfFecha.format(dateTime);
        } catch (ParseException e) {
            // Manejar cualquier excepción si ocurre algún error al parsear la fecha
            e.printStackTrace();
            return "Error"; // O cualquier otra cadena que desees devolver en caso de error
        }
    }

    public Date fecha(String columnName) {
        try {
            String dateString = columnName;
            if (dateString != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateFormat.parse(dateString);
            }
        } catch (ParseException e) {
            // Aquí puedes decidir cómo manejar la excepción, por ejemplo, imprimir un mensaje de error.
            System.err.println("Error al obtener o formatear la fecha: " + e.getMessage());
        }
        return null; // En caso de error o valor nulo, devuelve null.
    }

    public void cargarDatosAsignacionesProfe(JLabel lblTipoAsig, JLabel lblNomActTall, JLabel lblGrupo, String idProfesor) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de las asignaciones
            String sql = "SELECT Tipo_Asignacion, Nombre_ActividadTaller, Nombre_Grupo FROM AsignacionProfesor WHERE ID_DOCENTE = ?";
            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, idProfesor);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos a los labels
            while (resultSet.next()) {
                lblTipoAsig.setText(resultSet.getString("Tipo_Asignacion"));
                lblNomActTall.setText(resultSet.getString("Nombre_ActividadTaller"));
                lblGrupo.setText(resultSet.getString("Nombre_Grupo"));
            }

            System.out.println("Datos de asignaciones cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos de las asignaciones: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public Profesor ObtenerDatosProfesor(String usuario, String contra) {
        Profesor profesor = null;
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del profesor con el usuario y contraseña proporcionados
            String sql = "SELECT id_profesor, cedula, nombres, apellidos, correo, especialidad, experiencia, fecha_Nacimiento FROM Profesores WHERE usuario = ? AND contra = ?";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contra);

            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontraron resultados y si es así, crear el objeto Profesor
            if (resultSet.next()) {
                String idProfesor = resultSet.getString("id_profesor");
                String cedula = resultSet.getString("cedula");
                String nombres = resultSet.getString("nombres");
                String apellidos = resultSet.getString("apellidos");
                String correo = resultSet.getString("correo");
                String especialidad = resultSet.getString("especialidad");
                int experiencia = resultSet.getInt("experiencia");
                Date fechaNacimiento = resultSet.getDate("fecha_Nacimiento");

                // Usar el constructor de la clase Profesor para crear el objeto profesor
                profesor = new Profesor(idProfesor, especialidad, experiencia, cedula, nombres, apellidos, usuario, contra, correo, fechaNacimiento);
            }

            System.out.println("Datos del profesor cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos del profesor: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return profesor;
    }

    public boolean actualizarDatosProfesor(String nuevosNombres, String nuevosApellidos, String nuevoUsuario, String nuevoCorreo, String nuevaContrasena) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para realizar la actualización
            String sql = "UPDATE Profesores SET nombres = ?, apellidos = ?, correo = ? WHERE id_profesor = ?";

            // Crear la declaración y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, nuevosNombres);
            statement.setString(2, nuevosApellidos);
            statement.setString(3, nuevoCorreo);
            statement.setString(4, id_profesor); // Asegúrate de definir id_profesor en tu clase

            // Ejecutar la consulta de actualización
            int filasActualizadas = statement.executeUpdate();

            if (filasActualizadas > 0) {
                if (!nuevoUsuario.isEmpty() && !nuevaContrasena.isEmpty()) {
                    // Actualizar también el nombre de usuario y contraseña en la tabla Usuarios
                    actualizarCredencialesUsuario(nuevoUsuario, nuevaContrasena);
                }

                JOptionPane.showMessageDialog(null, "Datos del profesor actualizados correctamente.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún profesor con el ID especificado.", "Error de actualización", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos del profesor: " + e.getMessage(), "Error de actualización", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizarCredencialesUsuario(String nuevoUsuario, String nuevaContrasena) {
        try {
            // Crear la sentencia SQL para actualizar las credenciales en la tabla Usuarios
            String sql = "UPDATE Usuarios SET nombre_usuario = ?, contrasena = ? WHERE nombre_usuario = ?";

            // Crear la declaración y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, nuevoUsuario);
            statement.setString(2, nuevaContrasena);
            statement.setString(3, nuevoUsuario);

            // Ejecutar la consulta de actualización
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar las credenciales del usuario: " + e.getMessage());
        }
    }

    // Método para convertir la cadena de fecha a objeto Date
    private Date obtenerFecha(String fechaStr) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            return formatoFecha.parse(fechaStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha: " + e.getMessage(), "Error de fecha", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void cargarTalleresDocente(JComboBox<String> cmbTallerAsistencias, String idDocente) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT DISTINCT NOMBRE_ACTIVIDADTALLER FROM ASIGNACIONPROFESOR WHERE ID_DOCENTE = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, idDocente);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombreTaller = resultSet.getString("NOMBRE_ACTIVIDADTALLER");
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

    public void cargarGruposDocente(JComboBox<String> cmbGrupoAsistencias, String idDocente) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT DISTINCT NOMBRE_GRUPO FROM ASIGNACIONPROFESOR WHERE ID_DOCENTE = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, idDocente);

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

    public void cargarTitulo(JComboBox<String> cmbGrupoAsistencias, String idAsignacion) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            String query = "SELECT DISTINCT TITUTLO FROM DEBER WHERE ID_ASIGNACION = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, idAsignacion);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String titulo = resultSet.getString("TITULO");
                cmbGrupoAsistencias.addItem(titulo);
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

    public boolean actualizarDatosUsuario(String nuevoUsuario, String nuevaContrasena, String usuarioAnterior) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para actualizar las credenciales en la tabla Usuarios
            String sql = "UPDATE Usuarios SET nombre_usuario = ?, contrasena = ? WHERE nombre_usuario = ?";

            // Crear la declaración y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, nuevoUsuario);
            statement.setString(2, nuevaContrasena);
            statement.setString(3, usuarioAnterior);

            // Ejecutar la consulta de actualización
            int filasActualizadas = statement.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al actualizar las credenciales del usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void agregarFilaAsistencia(JTable jTableAsistencias, JComboBox<String> cmbTalleresAsistencias, JComboBox<String> cmbGruposAsistencias, JDateChooser jDateFecha) {
        try {
            connectionBD.openConnection();

            String query = "SELECT Id_Recluso, Nombre_Recluso, Nombre_Taller, NOMBRE_GRUPO FROM Inscripcion WHERE Nombre_Taller = ? AND NOMBRE_GRUPO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);

            String tallerSeleccionado = cmbTalleresAsistencias.getSelectedItem().toString();
            String grupoSeleccionado = cmbGruposAsistencias.getSelectedItem().toString();

            statement.setString(1, tallerSeleccionado);
            statement.setString(2, grupoSeleccionado);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String idRecluso = resultSet.getString("Id_Recluso");
                String nombreRecluso = resultSet.getString("Nombre_Recluso");
                String nombreTaller = resultSet.getString("Nombre_Taller");
                String nombreGrupo = resultSet.getString("NOMBRE_GRUPO");

                // Generar el nuevo ID de asistencia
                String nuevoId = generarIdAsistencia();

                // Obtener la fecha seleccionada del jDateFecha
                Date fechaSeleccionada = jDateFecha.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = dateFormat.format(fechaSeleccionada);

                // Crear un Vector con los datos para agregar a la tabla
                Vector<Object> row = new Vector<>();
                row.add(nuevoId);
                row.add(idRecluso);
                row.add(nombreRecluso);
                row.add(nombreTaller);
                row.add(nombreGrupo);
                row.add(fecha);
                row.add(Boolean.FALSE); // Por defecto, asistencia "No"

                // Agregar la fila al modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) jTableAsistencias.getModel();
                model.addRow(row);
            }

            resultSet.close();
            statement.close();
            connectionBD.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validarExistenciaReclusos(String curso, String grupo) {
        try {
            connectionBD.openConnection();

            String query = "SELECT COUNT(*) AS count FROM Inscripcion WHERE Nombre_Taller = ? AND NOMBRE_GRUPO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, curso);
            statement.setString(2, grupo);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");

            resultSet.close();
            statement.close();
            connectionBD.closeConnection();

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarCoincidencias(JComboBox<String> cmbTalleres, JComboBox<String> cmbGrupos) {
        String tallerSeleccionado = cmbTalleres.getSelectedItem().toString();
        String grupoSeleccionado = cmbGrupos.getSelectedItem().toString();

        try {
            connectionBD.openConnection();

            String query = "SELECT Id_Recluso, Nombre_Recluso FROM Inscripcion WHERE Nombre_Taller = ? AND NOMBRE_GRUPO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, tallerSeleccionado);
            statement.setString(2, grupoSeleccionado);

            ResultSet resultSet = statement.executeQuery();

            // Verificar si hay resultados en la consulta
            boolean coincidenciasEncontradas = resultSet.next();

            resultSet.close();
            statement.close();
            connectionBD.closeConnection();

            return coincidenciasEncontradas;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Manejo de la excepción
            return false;
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

    public String getIdAsignacion() throws ClassNotFoundException, SQLException {
        String idAsignacion = ""; // Inicializa con un valor por defecto
        ConnectionBD connectionBD = new ConnectionBD();

        try {
            connectionBD.openConnection();

            // Consulta para obtener el idAsignacion de algún deber existente
            String queryIdAsignacion = "SELECT Id_Asignacion FROM DEBER FETCH FIRST 1 ROWS ONLY";
            PreparedStatement statementIdAsignacion = connectionBD.getConnection().prepareStatement(queryIdAsignacion);

            ResultSet resultSetIdAsignacion = statementIdAsignacion.executeQuery();

            if (resultSetIdAsignacion.next()) {
                idAsignacion = resultSetIdAsignacion.getString("Id_Asignacion");
            }

            resultSetIdAsignacion.close();
            statementIdAsignacion.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de la excepción
        } finally {
            connectionBD.closeConnection();
        }

        return idAsignacion;
    }

    public void cargarFechaCreacionTallerSeleccionado(String nombreTaller, JDateChooser jDateFecha) throws SQLException {
        try {
            connectionBD.openConnection();

            String query = "SELECT FECHA_CREACION FROM TalleresAlcaide WHERE NOMBRE_TALLER = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nombreTaller);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String fechaCreacion = resultSet.getString("FECHA_CREACION");
                jDateFecha.setDate(fecha(fechaCreacion)); // Suponiendo que fecha es un método para convertir la cadena a un objeto Date
            }

            resultSet.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Manejo de la excepción
        } finally {
            connectionBD.closeConnection();
        }
    }
    //Método para cargar la fecha de vencimiento de un taller 
    public void cargarFechaVencimientoTallerSeleccionado(String nombreTaller, JDateChooser jDateFecha) throws SQLException {
        try {
            connectionBD.openConnection();

            String query = "SELECT FECHA_VENCIMIENTO FROM TalleresAlcaide WHERE NOMBRE_TALLER = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, nombreTaller);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String fechaVencimiento = resultSet.getString("FECHA_VENCIMIENTO");
                jDateFecha.setDate(fecha(fechaVencimiento)); // Suponiendo que fecha es un método para convertir la cadena a un objeto Date
            }

            resultSet.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Manejo de la excepción
        } finally {
            connectionBD.closeConnection();
        }
    }
    //Método para guardar las asistencias
    public void guardarAsistencias(JTable jTableAsistencias) {
        try {
            connectionBD.openConnection();
            DefaultTableModel model = (DefaultTableModel) jTableAsistencias.getModel();

            String query = "INSERT INTO Asistencias (Id_asistencia, Id_recluso, Nombre_recluso, taller, grupo, fecha, asistencia) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);

            for (int i = 0; i < model.getRowCount(); i++) {
                statement.setString(1, model.getValueAt(i, 0).toString());
                statement.setString(2, model.getValueAt(i, 1).toString());
                statement.setString(3, model.getValueAt(i, 2).toString());
                statement.setString(4, model.getValueAt(i, 3).toString());
                statement.setString(5, model.getValueAt(i, 4).toString());

                Object fechaObjeto = model.getValueAt(i, 5);
                String fechaString = fechaObjeto.toString();
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);
                statement.setDate(6, new java.sql.Date(fecha.getTime()));

                // Convertir el valor de asistencia a "Presente" o "Ausente"
                boolean asistenciaBoolean = (boolean) model.getValueAt(i, 6);
                String asistencia = asistenciaBoolean ? "Presente" : "Ausente";
                statement.setString(7, asistencia);

                statement.executeUpdate();
            }

            statement.close();
            connectionBD.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarAsistencias(JComboBox<String> cmbTallerConsulta, JComboBox<String> cmbGrupoConsulta, JDateChooser jDateConsulta, JTable jTableAsistencias) throws SQLException {
        try {
            connectionBD.openConnection();

            String tallerSeleccionado = cmbTallerConsulta.getSelectedItem().toString();
            String grupoSeleccionado = cmbGrupoConsulta.getSelectedItem().toString();
            Date fechaSeleccionada = jDateConsulta.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());

            String query = "SELECT Id_asistencia, Id_recluso, Nombre_recluso, taller, grupo, fecha, asistencia FROM Asistencias WHERE taller = ? AND grupo = ? AND fecha = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, tallerSeleccionado);
            statement.setString(2, grupoSeleccionado);
            statement.setDate(3, fechaSQL);

            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTableAsistencias.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

            boolean registrosEncontrados = false;

            while (resultSet.next()) {
                String idAsistencia = resultSet.getString("Id_asistencia");
                String idRecluso = resultSet.getString("Id_recluso");
                String nombreRecluso = resultSet.getString("Nombre_recluso");
                String nombreTaller = resultSet.getString("taller");
                String nombreGrupo = resultSet.getString("grupo");
                Date fecha = resultSet.getDate("fecha");
                String asistenciaTexto = resultSet.getString("asistencia");

                // Mostrar un visto (checkmark) para "Presente" y nada para "Ausente"
                String asistenciaRenderizada = asistenciaTexto.equals("Presente") ? "✓" : "";

                // Agregar los datos a la tabla
                Object[] rowData = {idAsistencia, idRecluso, nombreRecluso, nombreTaller, nombreGrupo, fecha, asistenciaRenderizada};
                model.addRow(rowData);
                registrosEncontrados = true;

            }

            resultSet.close();
            statement.close();
            if (!registrosEncontrados) {
                JOptionPane.showMessageDialog(null, "No existen registros.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de la excepción
        } finally {

            connectionBD.closeConnection();
        }
    }

    public boolean verificarExistenciaRegistrosAsistencias() throws SQLException {
        try {
            connectionBD.openConnection();

            String query = "SELECT COUNT(*) FROM Asistencias";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);

            resultSet.close();
            statement.close();

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de la excepción
            return false;
        } finally {
            connectionBD.closeConnection();
        }
    }

    private String generarIdAsistencia() {
        // Obtener el último ID de asistencia desde la tabla (reemplaza con tu lógica)
        int ultimoId = 1; // Ejemplo, reemplaza con el último ID real

        // Generar el nuevo ID de asistencia
        String nuevoId = String.format("#AS%03d", ultimoId);

        return nuevoId;
    }

    public void actualizarDatos(String usuario, String correo, String contrasena) throws SQLException, ClassNotFoundException {
        try {
            connectionBD.openConnection();

            // Consulta para actualizar en la tabla "PROFESORES"
            String sqlActualizarProfesores = "UPDATE PROFESORES SET CORREO = ?, CONTRA = ?, USUARIO = ? WHERE ID_PROFESOR = ?";
            PreparedStatement statementProfesores = connectionBD.getConnection().prepareStatement(sqlActualizarProfesores);
            statementProfesores.setString(1, correo);
            statementProfesores.setString(2, contrasena);
            statementProfesores.setString(3, usuario);
            statementProfesores.setString(4, id_profesor); // Reemplaza idProfesor con el valor adecuado
            int profesoresUpdated = statementProfesores.executeUpdate();
            statementProfesores.close();

            // Consulta para actualizar en la tabla "USUARIOS"
            String sqlActualizarUsuarios = "UPDATE USUARIOS SET CORREO_ELECTRONICO = ?, CONTRASENA = ?, NOMBRE_USUARIO = ? WHERE ID_USUARIO = ?";
            PreparedStatement statementUsuarios = connectionBD.getConnection().prepareStatement(sqlActualizarUsuarios);
            statementUsuarios.setString(1, correo);
            statementUsuarios.setString(2, contrasena);
            statementUsuarios.setString(3, usuario);
            statementUsuarios.setString(4, id_profesor); // Reemplaza idUsuario con el valor adecuado
            int usuariosUpdated = statementUsuarios.executeUpdate();
            statementUsuarios.close();

            System.out.println("Datos actualizados en la tabla PROFESORES: " + profesoresUpdated + " filas afectadas");
            System.out.println("Datos actualizados en la tabla USUARIOS: " + usuariosUpdated + " filas afectadas");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBD.closeConnection();
        }
    }

}
