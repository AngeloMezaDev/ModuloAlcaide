/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.ConnectionBD;
import MODELO.Inscripcion;
import MODELO.Recluso;
import com.sun.jdi.connect.spi.Connection;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
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
    private static String idGrupo="";
    private static String nombreR = "";
    private static String apellidosR = "";
    private static String correo = "";
    private static String cedulaR= "";
    private static Date fechaNacimiento = null;
    

    public ctrlReclusos() {
        connectionBD = new ConnectionBD();
    }
    
    public void cargarIdGrupo(String Id_Taller) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos del recluso con el usuario y contraseña proporcionados
            String sql = "SELECT ID_GRUPO FROM Grupos where ID_TALLER = ? ";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, Id_Taller);
            
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                this.idGrupo = resultSet.getString("ID_GRUPO");
            }
            System.out.println("ID de Grupo cargada correctamente");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener el ID GRUPO: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
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
                this.nombreR = resultSet.getString("Nombres");
                this.apellidosR = resultSet.getString("apellidos");
                this.correo = resultSet.getString("correo");
                this.tiemp_condena = resultSet.getInt("tiempo_condena");
                this.delit = resultSet.getString("delito");
                this.cedulaR = resultSet.getString("cedula");
                this.fechaNacimiento = resultSet.getDate("fecha_nacimiento");
                lblCedula.setText(resultSet.getString("cedula"));
                lblApellidos.setText(resultSet.getString("apellidos"));
                lblNombres.setText(resultSet.getString("nombres"));
                lblTiempoCond.setText(resultSet.getString("tiempo_condena")+" años");
                lblDelito.setText(resultSet.getString("delito"));
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
   
    public void cargarNombresTalleres(JLabel lblTaller1, JLabel lblTaller2, JLabel lblTaller3, JLabel lblGrupo1, JLabel lblGrupo2, JLabel lblGrupo3) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de las asignaciones
            String sql = "Select nombre_taller, nombre_grupo from inscripcion where id_recluso = ?";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, id_recluso);
            ResultSet resultSet = statement.executeQuery();

            int contador = 0; // Para llevar un registro de los JLabels

            // Recorrer el resultado y agregar los datos a los labels
            while (resultSet.next() && contador < 3) {
                String nombreTaller = resultSet.getString("nombre_taller");
                String nombreGrupo = resultSet.getString("nombre_grupo");
                // Distribuir los nombres de taller en los JLabels correspondientes
                if (contador == 0) {
                    lblTaller1.setText(nombreTaller);
                    lblGrupo1.setText(nombreGrupo);
                } else if (contador == 1) {
                    lblTaller2.setText(nombreTaller);
                    lblGrupo2.setText(nombreGrupo);
                } else if (contador == 2) {
                    lblTaller3.setText(nombreTaller);
                    lblGrupo2.setText(nombreGrupo);
                }

                contador++;
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
    public void EditarRecluso(String nombre, String apellidos, String usuario, String correo, char[] contrasena) {
        try {
            connectionBD.openConnection();

             String sql = "{CALL sp_EditarRecluso(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        // Crear la declaración y establecer los parámetros
        CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
        cstmt.setString(1, id_recluso);
        cstmt.setString(2, cedulaR);
        cstmt.setString(3, nombre);
        cstmt.setString(4, apellidos);
        cstmt.setInt(5, tiemp_condena);
        cstmt.setString(6, delit);
        cstmt.setString(7, correo);
        cstmt.setString(8, usuario);
        String contrasenaString = new String(contrasena);
        cstmt.setString(9, contrasenaString);
        
        java.sql.Date fechaN = new java.sql.Date(fechaNacimiento.getTime());
        cstmt.setDate(10, fechaN);

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
    public void cargarDatosTalleresG(DefaultTableModel modeloTabla) throws ClassNotFoundException {
        try {
            connectionBD.openConnection();
            // Establecer la conexión a la base de datos (debes reemplazar los valores apropiados)           
            // Escribir la consulta SQL
            String sql = "SELECT TalleresAlcaide.ID_TALLER, TalleresAlcaide.NOMBRE_TALLER, TalleresAlcaide.REDUCCION_CONDENA, TalleresAlcaide.FECHA_CREACION, TalleresAlcaide.FECHA_VENCIMIENTO, Grupos.NOMBRE_GRUPO, Grupos.CAPACIDAD " +
             "FROM TalleresAlcaide " +
             "JOIN Grupos ON TalleresAlcaide.ID_TALLER = Grupos.ID_TALLER";


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
                
                
                
                Object[] fila = {
                    idTaller,
                    nombreTaller,
                    nombreGrupo,
                    reduccion,
                    fechaCreacion,
                    fechaVencimiento,
                    capacidadGrupo,
                    
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
    public void guardarTaller(Inscripcion inscripcion) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure de la inscripcion
            String sql = "CALL sp_Inscribir_Recluso(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Crear la declaración y establecer los parámetros
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, id_recluso);
            cstmt.setString(2, idGrupo); 
            cstmt.setString(3, nombreR);
            cstmt.setString(4, apellidosR);
            cstmt.setString(5, correo);
            cstmt.setString(6, inscripcion.getIdTaller());
            cstmt.setString(7, inscripcion.getNombreTaller());
            cstmt.setInt(8, inscripcion.getReduccionCondena());
            cstmt.setDate(9, new java.sql.Date(inscripcion.getFechaCreacion().getTime()));
            cstmt.setDate(10, new java.sql.Date(inscripcion.getFechaVencimiento().getTime()));
            cstmt.setString(11, inscripcion.getNombreGrupo());
            System.out.println("Nombre del grupo: "+ inscripcion.getNombreGrupo());

            cstmt.setInt(12, inscripcion.getCapacidadMaxima());
            
            
            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Inscripcion guardada correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al guardar la inscripcion: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

}

