package MODELO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class Taller {
    private String idTaller;
    private String nombreTaller;
    private int cantidadGrupos;
    private int capacidadMaxima;
    private Date fechaCreacion;

    public Taller(String idTaller, String nombreTaller, int cantidadGrupos, int capacidadMaxima, Date fechaCreacion) {
        this.idTaller = idTaller;
        this.nombreTaller = nombreTaller;
        this.cantidadGrupos = cantidadGrupos;
        this.capacidadMaxima = capacidadMaxima;
        this.fechaCreacion = fechaCreacion;
    }

    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public int getCantidadGrupos() {
        return cantidadGrupos;
    }

    public void setCantidadGrupos(int cantidadGrupos) {
        this.cantidadGrupos = cantidadGrupos;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void mostrarDatos(DefaultTableModel modeloTabla) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Object[] fila = {idTaller, nombreTaller, cantidadGrupos, capacidadMaxima, formatoFecha.format(fechaCreacion)};
        modeloTabla.addRow(fila);
    }
}
