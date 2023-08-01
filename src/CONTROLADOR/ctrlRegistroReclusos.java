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
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yordan
 */
public class ctrlRegistroReclusos {

    private ConnectionBD connectionBD;

    public ctrlRegistroReclusos() {
        connectionBD = new ConnectionBD();
    }

    public void RegistrarNuevoRecluso(Recluso recluso) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_RegistrarRecluso(?, ?, ?, ?, ?, ?, ?, ?, ?, ?); END;";

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

            System.out.println("Recluso registrado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al registrar el recluso: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public List<Recluso> cargarDatosRecluso(DefaultTableModel modeloTabla) {
        List<Recluso> reclusos = new ArrayList<>();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de los profesores
            String sql = "SELECT id_recluso, cedula, nombres, apellidos,tiempo_condena,delito,correo,usuario,contra,fecha_Nacimiento FROM Reclusos ORDER BY id_recluso ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Limpiar el modelo de tabla existente
            modeloTabla.setRowCount(0);

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                String idRecluso = resultSet.getString("id_recluso");
                String cedula = resultSet.getString("cedula");
                String nombres = resultSet.getString("nombres");
                String apellidos = resultSet.getString("apellidos");
                int condena = Integer.parseInt(resultSet.getString("tiempo_condena"));
                String delito = resultSet.getString("delito");
                String correo = resultSet.getString("correo");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contra");
                String fechaNacString = resultSet.getString("fecha_Nacimiento");

                Date fechaNac = null;
                try {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    fechaNac = formatoFecha.parse(fechaNacString);
                } catch (ParseException e) {
                    System.err.println("Error al convertir la fecha: " + e.getMessage());
                }

                Object[] fila = {
                    idRecluso,
                    nombres,
                    apellidos,
                    cedula,
                    correo,
                    delito,
                    condena
                };
                modeloTabla.addRow(fila);
                // Crear un objeto Profesor con los datos
                Recluso reo = new Recluso(idRecluso, condena, delito, cedula, nombres, apellidos, usuario, contrasena, correo, fechaNac);

                // Agregar el profesor a la lista
                reclusos.add(reo);
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
        return reclusos;
    }

    public List<Recluso> cargarDatosRecluso() {
        List<Recluso> reclusos = new ArrayList<>();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de los profesores
            String sql = "SELECT id_recluso, cedula, nombres, apellidos,tiempo_condena,delito,correo,usuario,contra,fecha_Nacimiento FROM Reclusos ORDER BY id_recluso ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                String idRecluso = resultSet.getString("id_recluso");
                String cedula = resultSet.getString("cedula");
                String nombres = resultSet.getString("nombres");
                String apellidos = resultSet.getString("apellidos");
                int condena = Integer.parseInt(resultSet.getString("tiempo_condena"));
                String delito = resultSet.getString("delito");
                String correo = resultSet.getString("correo");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contra");
                String fechaNacString = resultSet.getString("fecha_Nacimiento");

                Date fechaNac = null;
                try {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    fechaNac = formatoFecha.parse(fechaNacString);
                } catch (ParseException e) {
                    System.err.println("Error al convertir la fecha: " + e.getMessage());
                }

                // Crear un objeto Profesor con los datos
                Recluso reo = new Recluso(idRecluso, condena, delito, cedula, nombres, apellidos, usuario, contrasena, correo, fechaNac);

                // Agregar el profesor a la lista
                reclusos.add(reo);
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
        return reclusos;
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

    public boolean existeRecluso(String idRecluso) {
        boolean existe = false;

        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para consultar el recluso por su ID
            String sql = "SELECT 1 FROM Reclusos WHERE id_recluso = ?";

            // Crear la declaración y establecer el parámetro
            PreparedStatement pstmt = connectionBD.getConnection().prepareStatement(sql);
            pstmt.setString(1, idRecluso);

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Si se encuentra un registro, significa que el recluso existe
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al consultar si el recluso existe: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return existe;
    }

    public int consultarAsignacionesRecluso(String idRecluso) {
        int cantidadAsignaciones = 0;

        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para consultar las asignaciones del recluso
            String sql = "SELECT COUNT(*) AS cantidad FROM AsignacionRecluso WHERE Id_Recluso = ?";

            // Crear la declaración y establecer el parámetro
            PreparedStatement pstmt = connectionBD.getConnection().prepareStatement(sql);
            pstmt.setString(1, idRecluso);

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Obtener la cantidad de asignaciones del resultado
            if (rs.next()) {
                cantidadAsignaciones = rs.getInt("cantidad");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al consultar las asignaciones del recluso: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return cantidadAsignaciones;
    }

    public void eliminarRecluso(String idRecluso) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_EliminarRecluso(?); END;";

            // Crear la declaración y establecer el parámetro
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, idRecluso);

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Recluso eliminado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al eliminar el Recluso: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public List<Recluso> cargarReclusosComboBox(JComboBox<String> CmbReclusosExistentes) {
        CmbReclusosExistentes.removeAllItems();
        List<Recluso> reclusos = cargarDatosRecluso();
        CmbReclusosExistentes.addItem(("--Seleccione--"));
        for (Recluso recluso : reclusos) {
            // Accede a los atributos del objeto Recluso
            String nombresReclusos = (recluso.getNombres() + " " + recluso.getApellidos());
            CmbReclusosExistentes.addItem((nombresReclusos));
        }

        return reclusos;
    }

    public List<AsignacionRecluso> cargarDatosAsignacionesReos(DefaultTableModel modeloTabla) {
        List<AsignacionRecluso> asignaciones = new ArrayList<>();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de las asignaciones
            String sql = "SELECT * FROM AsignacionRecluso ORDER BY id_asignacion ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Limpiar el modelo de tabla existente
            modeloTabla.setRowCount(0);

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                String idAsignacion = resultSet.getString("ID_Asignacion");
                String idRecluso = resultSet.getString("Id_Recluso");
                String NombreRecluso = resultSet.getString("Nombre_Recluso");
                String tipoAsignacion = resultSet.getString("Tipo_Asignacion");
                String Nombre_ActTaller = resultSet.getString("Nombre_ActividadTaller");
                String idActTaller = resultSet.getString("Id_ActividadTaller");
                String NombreGrupo = resultSet.getString("Nombre_Grupo");
                Object[] fila = {
                    idAsignacion,
                    NombreRecluso,
                    idRecluso,
                    tipoAsignacion,
                    Nombre_ActTaller,
                    idActTaller,
                    NombreGrupo,};
                modeloTabla.addRow(fila);
                // Crear un objeto AsignacionProfesor con los datos
                AsignacionRecluso asignacion = new AsignacionRecluso(idAsignacion, idRecluso, NombreRecluso, tipoAsignacion, Nombre_ActTaller, idActTaller, NombreGrupo);

                // Agregar el profesor a la lista
                asignaciones.add(asignacion);
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
        return asignaciones;
    }

    public List<AsignacionRecluso> Lista_AsignacionesReos() {
        List<AsignacionRecluso> asignaciones = new ArrayList<>();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de las asignaciones
            String sql = "SELECT * FROM AsignacionRecluso ORDER BY id_asignacion ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                String idAsignacion = resultSet.getString("ID_Asignacion");
                String idRecluso = resultSet.getString("Id_Recluso");
                String NombreRecluso = resultSet.getString("Nombre_Recluso");
                String tipoAsignacion = resultSet.getString("Tipo_Asignacion");
                String Nombre_ActTaller = resultSet.getString("Nombre_ActividadTaller");
                String idActTaller = resultSet.getString("Id_ActividadTaller");
                String NombreGrupo = resultSet.getString("Nombre_Grupo");

                // Crear un objeto AsignacionProfesor con los datos
                AsignacionRecluso asignacion = new AsignacionRecluso(idAsignacion, idRecluso, NombreRecluso, tipoAsignacion, Nombre_ActTaller, idActTaller, NombreGrupo);

                // Agregar el profesor a la lista
                asignaciones.add(asignacion);
            }

            System.out.println("Lista de asignaciones cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos de las asignaciones: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return asignaciones;
    }

    public void agregarAsignacionRecluso(AsignacionRecluso asigancion) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al procedimiento almacenado
            String sql = "{call sp_AgregarAsignacionRecluso(?, ?, ?, ?, ?, ?)}";
            //obtener los datos:
            String IdRecluso = asigancion.getIdRecluso();
            String nombreRecluso = asigancion.getNombreRecluso();
            String tipoAsignacion = asigancion.getTipoAsignacion();
            String nombreActividadTaller = asigancion.getNombreActividadTaller();
            String idActividadTaller = asigancion.getIdActividadTaller();
            String nombreGrupo = asigancion.getNombreGrupo();

            // Crear el objeto CallableStatement
            CallableStatement stmt = connectionBD.getConnection().prepareCall(sql);
            stmt.setString(1, IdRecluso);
            stmt.setString(2, nombreRecluso);
            stmt.setString(3, tipoAsignacion);
            stmt.setString(4, nombreActividadTaller);
            stmt.setString(5, idActividadTaller);
            stmt.setString(6, nombreGrupo);

            // Ejecutar el procedimiento almacenado
            stmt.execute();

            System.out.println("Asignación de profesor agregada correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al agregar la asignación de profesor: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void editarAsignacion(AsignacionRecluso asignacion) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_EditarAsignacionProfesor(?, ?, ?, ?, ?, ?, ?); END;";

            // Crear la declaración y establecer los parámetros
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(2, asignacion.getIdRecluso());
            cstmt.setString(3, asignacion.getNombreRecluso());
            cstmt.setString(4, asignacion.getTipoAsignacion());
            cstmt.setString(5, asignacion.getNombreActividadTaller());
            cstmt.setString(6, asignacion.getIdActividadTaller());
            cstmt.setString(7, asignacion.getNombreGrupo());

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Asignacion editado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al editar la asignacion: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void eliminarAsignacion(String idAsignacion) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_eliminar_asignacionRecluso(?); END;";

            // Crear la declaración y establecer el parámetro
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, idAsignacion);

            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Profesor eliminado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al eliminar el profesor: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
