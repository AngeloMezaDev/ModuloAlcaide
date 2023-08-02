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
import com.toedter.calendar.JCalendar;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yordan
 */
public class ctrlProfesores {

    private ConnectionBD connectionBD;
    private static String id_profesor="";
    
    public ctrlProfesores() {
        connectionBD = new ConnectionBD();
    }

    public void cargarDatosProfesor(String usuario, String contra, JLabel lblApellidos, JLabel lblNombres, JLabel lblCedula, JLabel lblAñosExperiencia, JLabel lblEspecialidad, JLabel lblCorreo, JLabel lbledad, JLabel lblFechaNacs) {
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
                this.id_profesor = resultSet.getString("id_recluso");
                lblCedula.setText(resultSet.getString("cedula"));
                lblApellidos.setText(resultSet.getString("apellidos"));
                lblNombres.setText(resultSet.getString("nombres"));
                lblAñosExperiencia.setText(resultSet.getString("experiencia")+" años");
                lblEspecialidad.setText(resultSet.getString("especialidad"));
                lblCorreo.setText(resultSet.getString("correo"));
                lblFechaNacs.setText(obtenerSoloFecha(resultSet.getString("fecha_nacimiento")));
                lbledad.setText(calcularEdad(resultSet.getString("fecha_nacimiento"))+" años");
                
                
                Date fechaNac = null;
                try {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    fechaNac = formatoFecha.parse(lblFechaNacs.getText());
                } catch (ParseException e) {
                    System.err.println("Error al convertir la fecha: " + e.getMessage());
                }
            }
            System.out.println("Datos de reclusos cargados correctamente.");
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
    public void cargarDatosAsignacionesProfe(JLabel lblTipoAsig, JLabel lblNomActTall, JLabel lblGrupo) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de las asignaciones
            String sql = "SELECT Tipo_Asignacion, Nombre_ActividadTaller, Nombre_Grupo FROM AsignacionProfesor where id_profesor= ?";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, id_profesor);
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
public void cargarDatosTalleres(JCalendar cldAgenda) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL 
            String sql = "SELECT r.id_recluso, r.nombres || ' ' || r.apellidos AS nombre_recluso, a.tipo_asignacion, CASE WHEN a.tipo_asignacion = 'Actividad' THEN" +
            " act.fecha_hora_actividad  WHEN a.tipo_asignacion = 'Taller' THEN TO_CHAR(t.FECHA_CREACION, 'YYYY-MM-DD HH24:MI:SS')" +
            " ELSE NULL END AS fecha_asignacion FROM Reclusos r" +
            " JOIN AsignacionRecluso a ON r.id_recluso = a.id_recluso" +
            " LEFT JOIN actividades act ON a.Id_ActividadTaller = act.id_actividad" +
            " LEFT JOIN TalleresAlcaide t ON a.Id_ActividadTaller = t.ID_TALLER" +
            " WHERE r.id_recluso = ?";


            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, id_profesor);
            ResultSet resultSet = statement.executeQuery();           
            // Recorrer el resultado           
            while (resultSet.next()) {
                String fechaCreacion =resultSet.getString("fecha_asignacion");
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
            String sql = "SELECT r.id_recluso, r.nombres || ' ' || r.apellidos AS nombre_recluso, a.tipo_asignacion, CASE WHEN a.tipo_asignacion = 'Actividad' THEN" +
            " act.fecha_hora_actividad  WHEN a.tipo_asignacion = 'Taller' THEN TO_CHAR(t.FECHA_CREACION, 'YYYY-MM-DD HH24:MI:SS')" +
            " ELSE NULL END AS fecha_asignacion FROM Reclusos r" +
            " JOIN AsignacionRecluso a ON r.id_recluso = a.id_recluso" +
            " LEFT JOIN actividades act ON a.Id_ActividadTaller = act.id_actividad" +
            " LEFT JOIN TalleresAlcaide t ON a.Id_ActividadTaller = t.ID_TALLER" +
            " WHERE r.id_recluso = ?";


            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, id_profesor);
            ResultSet resultSet = statement.executeQuery();           
            // Recorrer el resultado           
            while (resultSet.next()) {
                fechaCreacion =resultSet.getString("fecha_asignacion");
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
        return  fecha(fechaCreacion);
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

}
