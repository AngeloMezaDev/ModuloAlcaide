/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.ConnectionBD;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Angelo Meza
 */
public class ctrlAsignacionProfe {

    private ConnectionBD connectionBD;

    public ctrlAsignacionProfe() {
        connectionBD = new ConnectionBD();
    }

  public void guardarAsignacion(
        JTextField txtTitulo,
        JComboBox<String> cmbCurso,
        JComboBox<String> cmbGrupo,
        JDateChooser jDateFechaAsignacion,
        JTextArea txtDescripcion,
        JLabel lblId
) throws SQLException, ClassNotFoundException {
    ConnectionBD connectionBD = new ConnectionBD();

    try {
        connectionBD.openConnection();

        String nuevoId = generarIdAsignacion();

        String query = "INSERT INTO Asignacion (Id_Asignacion, Titulo, Curso, Grupo, Fecha_Limite, Descripcion) VALUES (?, ?, ?, ?, TO_DATE(?, 'dd-MM-yyyy'), ?)";
        PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
        statement.setString(1, nuevoId);
        statement.setString(2, txtTitulo.getText());
        statement.setString(3, cmbCurso.getSelectedItem().toString());
        statement.setString(4, cmbGrupo.getSelectedItem().toString());

        Date fechaAsignacion = jDateFechaAsignacion.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaStr = dateFormat.format(fechaAsignacion);
        statement.setString(5, fechaStr);

        statement.setString(6, txtDescripcion.getText());

        statement.executeUpdate();
        statement.close();

        lblId.setText(nuevoId);

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        connectionBD.closeConnection();
    }
}


    public String generarIdAsignacion() throws ClassNotFoundException, SQLException {
        try {
            connectionBD.openConnection();

            String query = "SELECT MAX(Id_Asignacion) FROM Asignacion";
            PreparedStatement statement = connectionBD.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int maxId = 0;
            if (resultSet.next()) {
                String maxIdStr = resultSet.getString(1);
                if (maxIdStr != null) {
                    maxId = Integer.parseInt(maxIdStr.substring(3)); // Extraer el número después del #
                }
            }

            maxId++; // Incrementar el ID
            String nuevoId = String.format("#AP%03d", maxId); // Generar el nuevo ID

            resultSet.close();
            statement.close();

            return nuevoId;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            connectionBD.closeConnection();
        }
    }
}
