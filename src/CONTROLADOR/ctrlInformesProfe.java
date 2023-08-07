package CONTROLADOR;

import MODELO.ConnectionBD;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.DriverManager;

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
}
