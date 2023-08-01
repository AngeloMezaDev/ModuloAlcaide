package CONTROLADOR;

import MODELO.AsignacionProfesor;
import MODELO.ConnectionBD;
import MODELO.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Yordan
 */
public class ctrlRegistroNuevoProfe {

    private ConnectionBD connectionBD;

    public ctrlRegistroNuevoProfe() {
        connectionBD = new ConnectionBD();
    }

    public void RegistrarNuevoProfe(Profesor profesor) {
        try {
            connectionBD.openConnection();
            // Crear la sentencia SQL para insertar el nuevo profesor
            String sql = "INSERT INTO Profesores (id_profesor, cedula, nombres, apellidos, correo, especialidad, experiencia, usuario, contra, fecha_Nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Crear la declaración preparada y establecer los parámetros
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            statement.setString(1, profesor.getCodigoProfesor());
            statement.setString(2, profesor.getCedula());
            statement.setString(3, profesor.getNombres());
            statement.setString(4, profesor.getApellidos());
            statement.setString(5, profesor.getCorreo());
            statement.setString(6, profesor.getEspecialidad());
            statement.setInt(7, profesor.getAñosExperiencia());
            statement.setString(8, profesor.getUser());
            statement.setString(9, profesor.getPassword());
            java.sql.Date fechaNacimiento = new java.sql.Date(profesor.getFechaNacimiento().getTime());
            statement.setDate(10, fechaNacimiento);

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

    public List<Profesor> cargarDatosProfesores(DefaultTableModel modeloTabla) {
        List<Profesor> profesores = new ArrayList<>();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de los profesores
            String sql = "SELECT * FROM Profesores ORDER BY id_profesor ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Limpiar el modelo de tabla existente
            modeloTabla.setRowCount(0);

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                String idProfesor = resultSet.getString("id_profesor");
                String nombres = resultSet.getString("nombres");
                String apellidos = resultSet.getString("apellidos");
                String cedula = resultSet.getString("cedula");
                String correo = resultSet.getString("correo");
                String especialidad = resultSet.getString("especialidad");
                int experiencia = Integer.parseInt(resultSet.getString("experiencia"));
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
                    idProfesor,
                    nombres,
                    apellidos,
                    cedula,
                    correo,
                    especialidad,
                    experiencia,
                    usuario,
                    contrasena
                };
                modeloTabla.addRow(fila);
                // Crear un objeto Profesor con los datos
                Profesor profesor = new Profesor(idProfesor, especialidad, experiencia, cedula, nombres, apellidos, usuario, contrasena, correo, fechaNac);

                // Agregar el profesor a la lista
                profesores.add(profesor);
            }

            System.out.println("Datos de profesores cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos de los profesores: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return profesores;
    }

    public List<Profesor> cargarDatosProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        try {
            connectionBD.openConnection();
            // Crear la sentencia SQL para obtener los datos de los profesores
            String sql = "SELECT id_profesor, nombres, apellidos, cedula, correo, especialidad, experiencia,usuario,contra,fecha_nacimiento FROM Profesores ORDER BY id_profesor ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                String idProfesor = resultSet.getString("id_profesor");
                String nombres = resultSet.getString("nombres");
                String apellidos = resultSet.getString("apellidos");
                String cedula = resultSet.getString("cedula");
                String correo = resultSet.getString("correo");
                String especialidad = resultSet.getString("especialidad");
                int experiencia = Integer.parseInt(resultSet.getString("experiencia"));
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
                Profesor profesor = new Profesor(idProfesor, especialidad, experiencia, cedula, nombres, apellidos, usuario, contrasena, correo, fechaNac);

                // Agregar el profesor a la lista
                profesores.add(profesor);
            }

            System.out.println("Datos de profesores cargados correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los datos de los profesores: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return profesores;
    }

    public void cargarProfesoresComboBox(JComboBox<String> comboBox) {
        try {
            connectionBD.openConnection();
            // Limpiar el JComboBox
            comboBox.removeAllItems();
            // Crear la sentencia SQL para obtener los nombres de docentes
            String sql = "SELECT nombres || ' ' || apellidos AS nombre_completo\n"
                    + "FROM Profesores\n"
                    + "ORDER BY nombres ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Crear el modelo para el JComboBox
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            comboBoxModel.removeAllElements();
            comboBoxModel.addElement("--Seleccione--");

            // Recorrer el resultado y agregar los datos al modelo del combo
            while (resultSet.next()) {
                String nombreCompleto = resultSet.getString("nombre_completo");
                comboBoxModel.addElement(nombreCompleto);
            }

            // Asignar el modelo del JComboBox
            comboBox.setModel(comboBoxModel);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los nombres de docentes: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void cargarActividadesComboBox(JComboBox<String> comboBox) {
        try {
            connectionBD.openConnection();
            // Limpiar el JComboBox
            comboBox.removeAllItems();
            // Crear la sentencia SQL para obtener los nombres de Actividades
            String sql = "SELECT nombre_actividad AS NombreActividad FROM actividades";
            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Crear el modelo para el JComboBox
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            comboBoxModel.addElement("--Seleccione--");

            // Recorrer el resultado y agregar los datos al modelo del combo
            while (resultSet.next()) {
                String nombreAct = resultSet.getString("NombreActividad");
                System.out.println(nombreAct);
                comboBoxModel.addElement(nombreAct);
            }

            // Asignar el modelo del JComboBox
            comboBox.setModel(comboBoxModel);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener las actividades: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void cargarTalleresComboBox(JComboBox<String> comboBox) {
        try {
            connectionBD.openConnection();
            // Limpiar el JComboBox
            comboBox.removeAllItems();
            // Crear la sentencia SQL para obtener los nombres de Actividades
            String sql = "SELECT NOMBRE_TALLER AS NombreTaller FROM TALLERESALCAIDE";
            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Crear el modelo para el JComboBox
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            comboBoxModel.addElement("--Seleccione--");

            // Recorrer el resultado y agregar los datos al modelo del combo
            while (resultSet.next()) {
                String nombreTaller = resultSet.getString("NombreTaller");
                comboBoxModel.addElement(nombreTaller);
            }

            // Asignar el modelo del JComboBox
            comboBox.setModel(comboBoxModel);
            // Cerrar la conexión
            connectionBD.closeConnection();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los talleres: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public void eliminarProfesor(String idProfesor) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN eliminar_profesor(?); END;";

            // Crear la declaración y establecer el parámetro
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, idProfesor);

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

    public void editarProfesor(String idProfesor, String nuevaCedula, String nuevosNombres, String nuevosApellidos, String nuevoCorreo, String nuevaEspecialidad, int nuevaExperiencia, String nuevoUsuario, String nuevaContra, Date FechaNac) {

        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_editar_profesor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?); END;";

            // Crear la declaración y establecer los parámetros
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, idProfesor);
            cstmt.setString(2, nuevosNombres);
            cstmt.setString(3, nuevosApellidos);
            cstmt.setString(4, nuevaCedula); // Corregir el orden del parámetro aquí
            cstmt.setString(5, nuevoCorreo);
            cstmt.setString(6, nuevaEspecialidad);
            cstmt.setInt(7, nuevaExperiencia);
            cstmt.setString(8, nuevoUsuario);
            cstmt.setString(9, nuevaContra);
            java.sql.Date fechaNacimiento = new java.sql.Date(FechaNac.getTime());
            cstmt.setDate(10, fechaNacimiento);
            // Ejecutar el stored procedure
            cstmt.execute();

            System.out.println("Profesor editado correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al editar el profesor: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public boolean existeProfesor(String idProfesor) {
        boolean existe = false;

        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para consultar el profesor por su ID
            String sql = "SELECT 1 FROM Profesores WHERE id_profesor = ?";

            // Crear la declaración y establecer el parámetro
            PreparedStatement pstmt = connectionBD.getConnection().prepareStatement(sql);
            pstmt.setString(1, idProfesor);

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Si se encuentra un registro, significa que el profesor existe
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al consultar si el profesor existe: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return existe;
    }

    public int consultarAsignacionesProfesor(String idProfesor) {
        int cantidadAsignaciones = 0;

        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para consultar las asignaciones del profesor
            String sql = "SELECT COUNT(*) AS cantidad FROM AsignacionProfesor WHERE id_docente = ?";

            // Crear la declaración y establecer el parámetro
            PreparedStatement pstmt = connectionBD.getConnection().prepareStatement(sql);
            pstmt.setString(1, idProfesor);

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Obtener la cantidad de asignaciones del resultado
            if (rs.next()) {
                cantidadAsignaciones = rs.getInt("cantidad");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al consultar las asignaciones del profesor: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return cantidadAsignaciones;
    }

    public String ObtenerTaller(String NombreTaller) {
        String idTaller = null;
        try {
            connectionBD.openConnection();
            // Consulta SQL para obtener el ID del taller por nombre
            String sql = "SELECT ID_TALLER FROM TalleresAlcaide WHERE NOMBRE_TALLER = ?";

            PreparedStatement stmt = connectionBD.getConnection().prepareStatement(sql);
            stmt.setString(1, NombreTaller);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idTaller = rs.getString("ID_TALLER");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener el Id Taller: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return idTaller;
    }

    public void cargarGruposTalleres(String idTaller, JComboBox<String> comboBoxGrupos) {
        try {
            String nombreGrupo = "";
            // Lógica de conexión a la base de datos
            connectionBD.openConnection();
            // Crear el modelo para el JComboBox
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            comboBoxModel.removeAllElements();
            comboBoxModel.addElement("--Seleccione--");
            // Consulta SQL para obtener los nombres de los grupos por ID de taller
            String sql = "SELECT nombre_grupo FROM Grupos WHERE ID_TALLER = ?";
            PreparedStatement stmt = connectionBD.getConnection().prepareStatement(sql);
            stmt.setString(1, idTaller);
            ResultSet rs = stmt.executeQuery();

            // Recorrer el resultado y agregar los nombres de los grupos a la lista
            while (rs.next()) {
                nombreGrupo = rs.getString("nombre_grupo");
                comboBoxModel.addElement(nombreGrupo);
            }
            System.out.println("la consulta devuelve el grupo:" + nombreGrupo);
            comboBoxGrupos.setModel(comboBoxModel);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener nombre de Grupos: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public List<AsignacionProfesor> cargarDatosAsignaciones(DefaultTableModel defaultTableModel) {
        List<AsignacionProfesor> asignaciones = new ArrayList<>();
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para obtener los datos de las asignaciones
            String sql = "SELECT * FROM AsignacionProfesor ORDER BY id_asignacion ASC";

            // Crear la declaración y ejecutar la consulta
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Limpiar el modelo de tabla existente
            defaultTableModel.setRowCount(0);

            // Recorrer el resultado y agregar los datos al modelo de la tabla
            while (resultSet.next()) {
                String idAsignacion = resultSet.getString("id_asignacion");
                String idProfesor = resultSet.getString("Id_Docente");
                String NombreDocente = resultSet.getString("Nombre_Docente");
                String tipoAsignacion = resultSet.getString("Tipo_Asignacion");
                String Nombre_ActTaller = resultSet.getString("Nombre_ActividadTaller");
                String idActTaller = resultSet.getString("Id_ActividadTaller");
                String NombreGrupo = resultSet.getString("Nombre_Grupo");
                Object[] fila = {
                    idAsignacion,
                    NombreDocente,
                    idProfesor,
                    tipoAsignacion,
                    Nombre_ActTaller,
                    idActTaller,
                    NombreGrupo,};
                defaultTableModel.addRow(fila);
                // Crear un objeto AsignacionProfesor con los datos
                AsignacionProfesor asignacion = new AsignacionProfesor(idAsignacion, idProfesor, NombreDocente, tipoAsignacion, Nombre_ActTaller, idActTaller, NombreGrupo);

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

    public String ObtenerActividad(String nombreActividad) {
        String idActividad = null;
        try {
            connectionBD.openConnection();
            // Consulta SQL para obtener el ID del taller por nombre
            String sql = "SELECT ID_ACTIVIDAD FROM actividades WHERE nombre_actividad = ?";

            PreparedStatement stmt = connectionBD.getConnection().prepareStatement(sql);
            stmt.setString(1, nombreActividad);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idActividad = rs.getString("ID_ACTIVIDAD");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener el Id Taller: " + e.getMessage());
        } finally {
            try {
                connectionBD.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return idActividad;
    }

    public void agregarAsignacionProfesor(String idDocente, String nombreDocente, String tipoAsignacion,
            String nombreActividadTaller, String idActividadTaller, String nombreGrupo) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al procedimiento almacenado
            String sql = "{call sp_AgregarAsignacionProfesor(?, ?, ?, ?, ?, ?)}";

            // Crear el objeto CallableStatement
            CallableStatement stmt = connectionBD.getConnection().prepareCall(sql);
            stmt.setString(1, idDocente);
            stmt.setString(2, nombreDocente);
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

    public void editarAsignacion(AsignacionProfesor asignacion) {
        try {
            connectionBD.openConnection();

            // Crear la sentencia SQL para llamar al stored procedure
            String sql = "BEGIN sp_EditarAsignacionProfesor(?, ?, ?, ?, ?, ?, ?); END;";

            // Crear la declaración y establecer los parámetros
            CallableStatement cstmt = connectionBD.getConnection().prepareCall(sql);
            cstmt.setString(1, asignacion.getIdAsignacion());
            cstmt.setString(2, asignacion.getIdDocente());
            cstmt.setString(3, asignacion.getNombreDocente());
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
            String sql = "BEGIN sp_eliminar_asignacion(?); END;";

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
