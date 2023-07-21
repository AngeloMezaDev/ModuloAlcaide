/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.AsignacionRecluso;
import MODELO.ConnectionBD;
import MODELO.Recluso;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yordan
 */
public class ctrlReclusos {

    private ConnectionBD connectionBD;
    private static String id_recluso="";
    
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
   

}
