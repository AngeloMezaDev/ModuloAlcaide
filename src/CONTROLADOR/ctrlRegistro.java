package CONTROLADOR;

import java.util.List;
import MODELO.Actividad;
import MODELO.ConnectionBD;
import MODELO.Taller;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
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

            // Crear la sentencia SQL para obtener las actividades ordenadas por ID_ACTIVIDAD
            String sql = "SELECT ID_ACTIVIDAD, NOMBRE_ACTIVIDAD, DESCRIPCION_ACTIVIDAD, FECHA_HORA_ACTIVIDAD FROM Actividades ORDER BY ID_ACTIVIDAD ASC";

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
            // Crear la sentencia SQL para obtener las actividades ordenadas por ID_ACTIVIDAD
            String sql = "INSERT INTO Actividades (ID_ACTIVIDAD, NOMBRE_ACTIVIDAD, DESCRIPCION_ACTIVIDAD, FECHA_HORA_ACTIVIDAD) VALUES (?, ?, ?, ?)";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, actividad.getIdActividad());
            statement.setString(2, actividad.getNombreActividad());
            statement.setString(3, actividad.getDescripcionActividad());
            statement.setString(4, fechaHoraActividad);

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

    public void editarActividad(String idActividad, String nuevoNombre, String nuevaDescripcion) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_editar_actividad(?, ?, ?); END;";

            // Crear la declaración y establecer los parámetros
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, idActividad);
            cstmt.setString(2, nuevoNombre);
            cstmt.setString(3, nuevaDescripcion);

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Actividad editada correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al editar la actividad: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void eliminarActividad(String idActividad) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_eliminar_actividad(?); END;";

            // Crear la declaración y establecer el parámetro
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, idActividad);

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Actividad eliminada correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al eliminar la actividad: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    // Métodos para talleres

   public void cargarDatosTalleres(DefaultTableModel modeloTabla) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los talleres ordenados por ID
            String sql = "SELECT ID_TALLER, NOMBRE_TALLER, CANTIDAD_GRUPOS, CAPACIDAD_MAXIMA, FECHA_CREACION, FECHA_VENCIMIENTO, REDUCCION_CONDENA FROM TalleresAlcaide ORDER BY ID_TALLER ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            while (resultSet.next()) {
                String id = resultSet.getString("ID_TALLER");
                String nombreTaller = resultSet.getString("NOMBRE_TALLER");
                String cantidadGrupos = resultSet.getString("CANTIDAD_GRUPOS");
                String capacidadMaxima = resultSet.getString("CAPACIDAD_MAXIMA");
                Date fechaCreacion = resultSet.getDate("FECHA_CREACION");
                Date fechaVencimiento = resultSet.getDate("FECHA_VENCIMIENTO");
                String reduccionCondena = resultSet.getString("REDUCCION_CONDENA");

                // Convertir la fecha al formato deseado
                String fechaCreacionStr = formatoFecha.format(fechaCreacion);
                String fechaVencimientoStr = formatoFecha.format(fechaVencimiento);

                Object[] fila = {
                    id,
                    nombreTaller,
                    cantidadGrupos,
                    capacidadMaxima,
                    fechaCreacionStr,
                    fechaVencimientoStr,
                    reduccionCondena
                };
                modeloTabla.addRow(fila);
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

    public void guardarTaller(Taller taller) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure de agregar taller
            String sql = "CALL sp_agregar_taller(?, ?, ?, ?, ?, ?)";

            // Crear la declaración y establecer los parámetros
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, taller.getNombreTaller());
            cstmt.setInt(2, taller.getCantidadGrupos());
            cstmt.setInt(3, taller.getCapacidadMaxima());
            cstmt.setDate(4, new java.sql.Date(taller.getFechaCreacion().getTime()));
            cstmt.setDate(5, new java.sql.Date(taller.getFechaVencimiento().getTime()));
            cstmt.setInt(6, taller.getReduccionCondena());

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Taller guardado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al guardar el taller: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void actualizarTaller(Taller taller) throws SQLException, ClassNotFoundException {
        connectionBD.openConnection();

        // Crear la sentencia SQL para actualizar los datos del taller
        String sql = "UPDATE TalleresAlcaide SET NOMBRE_TALLER = ?, CANTIDAD_GRUPOS = ?, CAPACIDAD_MAXIMA = ?, FECHA_CREACION = ?, FECHA_VENCIMIENTO = ?, REDUCCION_CONDENA= ? WHERE ID_TALLER = ?";

        // Crear la declaración y establecer los parámetros
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
        statement.setString(1, taller.getNombreTaller());
        statement.setInt(2, taller.getCantidadGrupos());
        statement.setInt(3, taller.getCapacidadMaxima());
        statement.setDate(4, new java.sql.Date(taller.getFechaCreacion().getTime()));
        statement.setDate(5, new java.sql.Date(taller.getFechaVencimiento().getTime()));
        statement.setInt(6, taller.getReduccionCondena());
        statement.setString(7, taller.getIdTaller());

        // Ejecutar la actualización
        statement.executeUpdate();

        System.out.println("Taller actualizado correctamente.");

        connectionBD.closeConnection();
    }

    public void eliminarTaller(String idTaller) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure de eliminar taller
            String sql = "CALL sp_eliminar_taller(?)";

            // Crear la declaración y establecer el parámetro
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, idTaller);

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Taller eliminado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al eliminar el taller: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }


    public void llamarStoredProcGenerarID() {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_insertar_actividad('', ''); END;";

            // Crear la declaración y ejecutar la llamada al stored procedure
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.execute();

            System.out.println("Stored procedure ejecutado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al llamar al stored procedure: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public String obtenerUltimoIDGenerado() {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener el último ID generado
            String sql = "SELECT MAX(ID_ACTIVIDAD) FROM Actividades";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Obtener el resultado
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener el último ID generado: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return null;
    }
}
