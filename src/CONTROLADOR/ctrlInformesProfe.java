package CONTROLADOR;

import MODELO.ConnectionBD;
import com.sun.jdi.connect.spi.Connection;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Angelo Meza
 */
public class ctrlInformesProfe {

    private ConnectionBD connectionBD;
    private int idInformeCounter = 1; // Declarar e inicializar el contador

    public ctrlInformesProfe() {
        connectionBD = new ConnectionBD();
    }

    public void cargarTareasPorFiltros(JTable jTableInforme, JComboBox<String> cmbCurso, JComboBox<String> cmbGrupo) throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) jTableInforme.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        String cursoSeleccionado = cmbCurso.getSelectedItem().toString();
        String grupoSeleccionado = cmbGrupo.getSelectedItem().toString();

        try {
            connectionBD.openConnection();

            String query = "SELECT * FROM Tareas WHERE CURSO = ? AND GRUPO = ?";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            statement.setString(1, cursoSeleccionado);
            statement.setString(2, grupoSeleccionado);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String idDeber = resultSet.getString("ID_DEBER");
                String idAsignacion = resultSet.getString("ID_ASIGNACION");
                String titulo = resultSet.getString("TITULO");
                String fechaLimite = resultSet.getString("FECHA_LIMITE");
                String curso = resultSet.getString("CURSO");
                String grupo = resultSet.getString("GRUPO");
                String descripcion = resultSet.getString("DESCRIPCION");
                String respuesta = resultSet.getString("RESPUESTA");
                String nombreAutor = resultSet.getString("NOMBRE_AUTOR");
                String apellidoAutor = resultSet.getString("APELLIDO_AUTOR");
                String idAutor = resultSet.getString("ID_AUTOR");
                String nota = resultSet.getString("NOTA");
                String observacion = resultSet.getString("OBSERVACION");

                String idInforme = "#IF" + String.format("%03d", idInformeCounter);
                idInformeCounter++; // Incrementar contador

                Object[] row = {idInforme, idDeber, idAsignacion, titulo, fechaLimite, curso, grupo, descripcion, respuesta, nombreAutor, apellidoAutor, idAutor, nota, observacion, ""};
                model.addRow(row);
            }

            resultSet.close();
            statement.close();
            connectionBD.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generarInforme(JComboBox<String> cmbCurso, JComboBox<String> cmbGrupo, JDateChooser jDateFechaVencimiento) {
    try {
        connectionBD.openConnection();

        String query = "SELECT * FROM Tareas WHERE CURSO = ? AND GRUPO = ?";
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
        statement.setString(1, cmbCurso.getSelectedItem().toString());
        statement.setString(2, cmbGrupo.getSelectedItem().toString());

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String idDeber = resultSet.getString("ID_DEBER");
            String idAsignacion = resultSet.getString("ID_ASIGNACION");
            String titulo = resultSet.getString("TITULO");
            Date fechaLimite = resultSet.getDate("FECHA_LIMITE");
            String curso = resultSet.getString("CURSO");
            String grupo = resultSet.getString("GRUPO");
            String descripcion = resultSet.getString("DESCRIPCION");
            String respuesta = resultSet.getString("RESPUESTA");
            String nombreAutor = resultSet.getString("NOMBRE_AUTOR");
            String apellidoAutor = resultSet.getString("APELLIDO_AUTOR");
            String idAutor = resultSet.getString("ID_AUTOR");
            String nota = resultSet.getString("NOTA");
            String observacion = resultSet.getString("OBSERVACION");

            String estado = Integer.parseInt(nota) >= 7 ? "Aprobado" : "Reprobado";

            String idInforme = "#IF" + String.format("%03d", idInformeCounter);
            idInformeCounter++; // Incrementar contador

            // Formatear la fecha al formato requerido por Oracle
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

            // Obtener la fecha del jDateFechaVencimiento
            Date fechaCreacionInfo = jDateFechaVencimiento.getDate();
            String fechaCreacionInfoFormateada = sdf.format(fechaCreacionInfo);

            // Insertar en la tabla Informes
            String insertQuery = "INSERT INTO Informes (ID_INFORME, ID_DEBER, ID_ASIGNACION, TITULO, FECHA_CREACION_INFO, CURSO, GRUPO, DESCRIPCION, RESPUESTA, NOMBRE_AUTOR, APELLIDO_AUTOR, ID_AUTOR, NOTA, OBSERVACION, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connectionBD.getConnection().prepareStatement(insertQuery);
            insertStatement.setString(1, idInforme);
            insertStatement.setString(2, idDeber);
            insertStatement.setString(3, idAsignacion);
            insertStatement.setString(4, titulo);
            insertStatement.setString(5, fechaCreacionInfoFormateada);
            insertStatement.setString(6, curso);
            insertStatement.setString(7, grupo);
            insertStatement.setString(8, descripcion);
            insertStatement.setString(9, respuesta);
            insertStatement.setString(10, nombreAutor);
            insertStatement.setString(11, apellidoAutor);
            insertStatement.setString(12, idAutor);
            insertStatement.setString(13, nota);
            insertStatement.setString(14, observacion);
            insertStatement.setString(15, estado);

            insertStatement.executeUpdate();
            insertStatement.close();
        }

        resultSet.close();
        statement.close();
        connectionBD.closeConnection();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}

public boolean existeInforme(String curso, String grupo) {
    boolean existe = false;

    try {
        connectionBD.openConnection();

        String query = "SELECT COUNT(*) FROM Tareas WHERE CURSO = ? AND GRUPO = ?";
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
        statement.setString(1, curso);
        statement.setString(2, grupo);

        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int rowCount = resultSet.getInt(1);
            existe = rowCount > 0;
        }

        resultSet.close();
        statement.close();
        connectionBD.closeConnection();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    return existe;
}

//consulta de informes
public void consultarInformes(JComboBox<String> cmbCurso, JComboBox<String> cmbGrupo, JDateChooser jDateFechaInforme, JTable jTableInformeGenerado) {
    try {
        connectionBD.openConnection();

        String cursoSeleccionado = cmbCurso.getSelectedItem().toString();
        String grupoSeleccionado = cmbGrupo.getSelectedItem().toString();
        Date fechaInforme = jDateFechaInforme.getDate();

        // Formatear la fecha al formato requerido por Oracle
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaFormateada = sdf.format(fechaInforme);

        String query = "SELECT * FROM Informes WHERE CURSO = ? AND GRUPO = ? AND FECHA_CREACION_INFO = ?";
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
        statement.setString(1, cursoSeleccionado);
        statement.setString(2, grupoSeleccionado);
        statement.setString(3, fechaFormateada);

        ResultSet resultSet = statement.executeQuery();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID_INFORME", "ID_DEBER", "ID_ASIGNACION", "TITULO", "FECHA_CREACION_INFO", "DESCRIPCION", "NOMBRE_AUTOR", "APELLIDO_AUTOR", "ID_AUTOR", "NOTA", "ESTADO"});

        while (resultSet.next()) {
            String idInforme = resultSet.getString("ID_INFORME");
            String idDeber = resultSet.getString("ID_DEBER");
            String idAsignacion = resultSet.getString("ID_ASIGNACION");
            String titulo = resultSet.getString("TITULO");
            Date fechaCreacionInfo = resultSet.getDate("FECHA_CREACION_INFO");
            String descripcion = resultSet.getString("DESCRIPCION");
            String nombreAutor = resultSet.getString("NOMBRE_AUTOR");
            String apellidoAutor = resultSet.getString("APELLIDO_AUTOR");
            String idAutor = resultSet.getString("ID_AUTOR");
            String nota = resultSet.getString("NOTA");
            String estado = resultSet.getString("ESTADO");

            model.addRow(new Object[]{idInforme, idDeber, idAsignacion, titulo, fechaCreacionInfo, descripcion, nombreAutor, apellidoAutor, idAutor, nota, estado});
        }

        jTableInformeGenerado.setModel(model);

        resultSet.close();
        statement.close();
        connectionBD.closeConnection();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
//Metodo para verificar si existen informes en la tabla INFORMES
public boolean existeInforme(String curso, String grupo, Date fechaInforme) {
    boolean existe = false;

    try {
        connectionBD.openConnection();

        String query = "SELECT COUNT(*) AS TOTAL FROM Informes WHERE CURSO = ? AND GRUPO = ? AND FECHA_CREACION_INFO = ?";
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
        statement.setString(1, curso);
        statement.setString(2, grupo);
        statement.setDate(3, new java.sql.Date(fechaInforme.getTime()));

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int total = resultSet.getInt("TOTAL");
            existe = total > 0;
        }

        resultSet.close();
        statement.close();
        connectionBD.closeConnection();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    return existe;
}

public boolean existeInformePorTallerYGrupo(String taller, String grupo) {
    boolean existe = false;

    try {
        connectionBD.openConnection();

        String query = "SELECT COUNT(*) AS TOTAL FROM Informes WHERE CURSO = ? AND GRUPO = ?";
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
        statement.setString(1, taller);
        statement.setString(2, grupo);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int total = resultSet.getInt("TOTAL");
            existe = total > 0;
        }

        resultSet.close();
        statement.close();
        connectionBD.closeConnection();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    return existe;
}


}
