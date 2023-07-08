
package MODELO;

/**
 *
 * @author Yordan
 */
public class Recluso extends Usuario{
    private String CodigoRecluso;
    private int Tiempo_condena;
    private String delito;
    private Actividad actividadAsignada;
    private Taller tallerAsignado;
    private String conducta;

    public Recluso(String CodigoRecluso, int Tiempo_condena, String delito, Actividad actividadAsignada, Taller tallerAsignado, String conducta, String cedula, String Nombres, String Apellidos, String User, String password, String correo) {
        super(cedula, Nombres, Apellidos, User, password, correo);
        this.CodigoRecluso = CodigoRecluso;
        this.Tiempo_condena = Tiempo_condena;
        this.delito = delito;
        this.actividadAsignada = actividadAsignada;
        this.tallerAsignado = tallerAsignado;
        this.conducta = conducta;
    }

    public String getCodigoRecluso() {
        return CodigoRecluso;
    }

    public void setCodigoRecluso(String CodigoRecluso) {
        this.CodigoRecluso = CodigoRecluso;
    }

    public int getTiempo_condena() {
        return Tiempo_condena;
    }

    public void setTiempo_condena(int Tiempo_condena) {
        this.Tiempo_condena = Tiempo_condena;
    }

    public String getDelito() {
        return delito;
    }

    public void setDelito(String delito) {
        this.delito = delito;
    }

    public Actividad getActividadAsignada() {
        return actividadAsignada;
    }

    public void setActividadAsignada(Actividad actividadAsignada) {
        this.actividadAsignada = actividadAsignada;
    }

    public Taller getTallerAsignado() {
        return tallerAsignado;
    }

    public void setTallerAsignado(Taller tallerAsignado) {
        this.tallerAsignado = tallerAsignado;
    }

    public String getConducta() {
        return conducta;
    }

    public void setConducta(String conducta) {
        this.conducta = conducta;
    }
    
}
