package CONTROLADOR;

import java.util.List;
import MODELO.Actividad;
import MODELO.ConnectionBD;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.internal.ResultSetCache;

public class ctrlRegistro {
    private ConnectionBD connectionBD;

    public ctrlRegistro() {
        connectionBD = new ConnectionBD();
    }
    public void cargarDatosActividades(DefaultTableModel modeloTabla) {
    try {
        connectionBD.openConnection();

        // Crear la sentencia SQL para obtener las actividades
        String sql = "SELECT ID_ACTIVIDAD, NOMBRE_ACTIVIDAD, DESCRIPCION_ACTIVIDAD, FECHA_HORA_ACTIVIDAD FROM Actividades";

        // Crear la declaración y ejecutar la consulta
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        // Recorrer el resultado y agregar los datos al modelo de la tabla
        while (resultSet.next()) {
            String idActividad = resultSet.getString("ID_ACTIVIDAD");
            String nombreActividad = resultSet.getString("NOMBRE_ACTIVIDAD");
            String descripcionActividad = resultSet.getString("DESCRIPCION_ACTIVIDAD");
            String fechaHoraActividad = resultSet.getString("FECHA_HORA_ACTIVIDAD");

            Object[] fila = {
                idActividad,
                nombreActividad,
                descripcionActividad,
                fechaHoraActividad
            };
            modeloTabla.addRow(fila);
        }

        System.out.println("Datos de actividades cargados correctamente.");
    } catch (SQLException | ClassNotFoundException e) {
        System.err.println("Error al obtener los datos de las actividades: " + e.getMessage());
    } finally {
        try {
            connectionBD.closeConnection();
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

    public void guardarActividad(Actividad actividad) {
        try {
            connectionBD.openConnection();
            //Obtener Fecha con el formato yyyy-MM-dd HH:mm:ss
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHoraActividad = dateFormat.format(actividad.getFechaHoraActividad());
            // Construir la sentencia SQL de inserción
            String sql = "INSERT INTO Actividades (ID_ACTIVIDAD, NOMBRE_ACTIVIDAD, DESCRIPCION_ACTIVIDAD, FECHA_HORA_ACTIVIDAD) VALUES (?, ?, ?, ?)";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, actividad.getIdActividad());
            statement.setString(2, actividad.getNombreActividad());
            statement.setString(3, actividad.getDescripcionActividad());
            statement.setString(4,fechaHoraActividad);

            // Ejecutar la inserción
            statement.executeUpdate();

            System.out.println("Los datos se han guardado en la base de datos.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al guardar los datos en la base de datos: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
  
}

