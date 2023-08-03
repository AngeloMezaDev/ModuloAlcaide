/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.ConnectionBD;
import MODELO.Recluso;
import com.sun.jdi.connect.spi.Connection;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import java.beans.Statement;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yordan
 */
public class ctrlReclusos {

    private ConnectionBD connectionBD;
    private static String id_recluso="";
    private static int tiemp_condena=0;
    private static String delit="";
    
    
    public ctrlReclusos() {
        connectionBD = new ConnectionBD();
    }

    public void cargarDatosRecluso(String usuario, String contra, JLabel lblApellidos, JLabel lblNombres, JLabel lblCedula, JLabel lblTiempoCond, JLabel lblDelito, JLabel lblCorreo, JLabel lbledad, JLabel lblFechaNacs) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "SELECT id_recluso, cedula, apellidos, nombres, tiempo_condena, delito, correo, fecha_nacimiento FROM Reclusos where usuario = ? AND contra = ?";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contra);
            
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                this.id_recluso = resultSet.getString("id_recluso");
                lblCedula.setText(resultSet.getString("cedula"));
                lblApellidos.setText(resultSet.getString("apellidos"));
                lblNombres.setText(resultSet.getString("nombres"));
                lblTiempoCond.setText(resultSet.getString("tiempo_condena")+" años");
                lblDelito.setText(resultSet.getString("delito"));
                lblCorreo.setText(resultSet.getString("correo"));
                lblFechaNacs.setText(obtenerSoloFecha(resultSet.getString("fecha_nacimiento")));
                lbledad.setText(calcularEdad(resultSet.getString("fecha_nacimiento"))+" años");
                this.tiemp_condena = resultSet.getInt("tiempo_condena");
                this.delit = resultSet.getString("delito");
                
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
   
    public void cargarDatosAsignacionesReos(JLabel lblTipoAsig, JLabel lblNomActTall, JLabel lblGrupo) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de las asignaciones
            String sql = "SELECT Tipo_Asignacion, Nombre_ActividadTaller, nombre_Grupo FROM AsignacionRecluso where id_recluso= ?";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, id_recluso);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos a los labels
            while (resultSet.next()) {
                lblTipoAsig.setText(resultSet.getString("Tipo_Asignacion"));
                lblNomActTall.setText(resultSet.getString("Nombre_ActividadTaller"));
                lblGrupo.setText(resultSet.getString("nombre_Grupo"));
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
    public void DatosRecluso(String usuario, String contra, JTextField lblApellidos, JTextField lblNombres, JTextField lblCedula, int tiempo_condena, String delito, JTextField lblCorreo, JDateChooser jDateFechaNac) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "SELECT id_recluso, cedula, apellidos, nombres, tiempo_condena, delito, correo, fecha_nacimiento FROM Reclusos where usuario = ? AND contra = ?";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contra);
            
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                this.id_recluso = resultSet.getString("id_recluso");
                System.out.println("IDDDD: "+ id_recluso);
                lblCedula.setText(resultSet.getString("cedula"));
                lblApellidos.setText(resultSet.getString("apellidos"));
                lblNombres.setText(resultSet.getString("nombres"));
                lblCorreo.setText(resultSet.getString("correo"));
                jDateFechaNac.setDate(fecha(resultSet.getString("fecha_nacimiento")));
                tiempo_condena = resultSet.getInt("tiempo_condena");
                delito = resultSet.getString("delito");
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
    public void EditarRecluso(Recluso recluso) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_EditarRecluso(?, ?, ?, ?, ?, ?, ?, ?, ?); END;";

            // Crear la declaración y establecer los parámetros
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, recluso.getCodigoRecluso());
            cstmt.setString(2, recluso.getCedula());
            cstmt.setString(3, recluso.getNombres());
            cstmt.setString(4, recluso.getApellidos());
            cstmt.setInt(5, recluso.getTiempo_condena());
            cstmt.setString(6, recluso.getDelito());
            cstmt.setString(7, recluso.getCorreo());
            cstmt.setString(8, recluso.getUser());
            cstmt.setString(9, recluso.getPassword());
            java.sql.Date fechaNacimiento = new java.sql.Date(recluso.getFechaNacimiento().getTime());
            cstmt.setDate(10, fechaNacimiento);

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Recluso editado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al editar el recluso: " + e.getMessage());
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
            statement.setString(1, id_recluso);
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
            statement.setString(1, id_recluso);
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
    public void cargarDatosTalleres(DefaultTableModel modeloTabla) throws ClassNotFoundException {
        try {
            connectionBD.openConnection();
            // Establecer la conexión a la base de datos (debes reemplazar los valores apropiados)           
            // Escribir la consulta SQL
            String sql = "SELECT ID_TALLER, NOMBRE_TALLER, REDUCCION_CONDENA, FECHA_CREACION, FECHA_VENCIMIENTO, NOMBRE_GRUPO, CAPACIDAD FROM TALLERESGRUPOS";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(); 

            // Procesar el resultado
            while (resultSet.next()) {
                String idTaller = resultSet.getString("ID_TALLER");
                String nombreTaller = resultSet.getString("NOMBRE_TALLER");
                int reduccion = resultSet.getInt("REDUCCION_CONDENA");
                Date fechaCreacion = resultSet.getDate("FECHA_CREACION");
                Date fechaVencimiento = resultSet.getDate("FECHA_VENCIMIENTO");
                String nombreGrupo = resultSet.getString("NOMBRE_GRUPO");
                int capacidadGrupo = resultSet.getInt("CAPACIDAD");

                // Realizar las operaciones necesarias con los datos obtenidos
                // (por ejemplo, imprimirlos o almacenarlos en objetos Java)
                Object[] fila = {
                    idTaller,
                    nombreTaller,
                    nombreGrupo,
                    reduccion,
                    fechaCreacion,
                    fechaVencimiento,
                    capacidadGrupo
                };
                modeloTabla.addRow(fila);
            }
           
            // Cerrar recursos
            resultSet.close();
            statement.close();
            connectionBD.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

