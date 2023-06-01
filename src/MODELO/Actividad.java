package MODELO;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angelo Meza
 */
public class Actividad {

    private String idActividad;
    private String nombreActividad;
    private String descripcionActividad;
    private Date fechaHoraActividad;

    // Constructor
    public Actividad(String idActividad, String nombreActividad, String descripcionActividad, Date fechaHoraActividad) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.descripcionActividad = descripcionActividad;
        this.fechaHoraActividad = fechaHoraActividad;
    }

    // Getters y Setters
    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Date getFechaHoraActividad() {
        return fechaHoraActividad;
    }

    public void setFechaHoraActividad(Date fechaHoraActividad) {
        this.fechaHoraActividad = fechaHoraActividad;
    }

    // Otros métodos y lógica de negocio relacionados con la actividad
    // Ejemplo de método para mostrar los datos de la actividad
    public void mostrarDatos(DefaultTableModel modeloTabla) {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object []fila = {idActividad,nombreActividad,descripcionActividad,formatoFecha.format(fechaHoraActividad)};
    modeloTabla.addRow(fila);
    } 
}
