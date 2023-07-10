
package MODELO;

import java.util.Date;

/**
 *
 * @author Yordan
 */
public class Recluso extends Usuario{
    private String CodigoRecluso;
    private int Tiempo_condena;
    private String delito;
    private String conducta;

    public Recluso(String CodigoRecluso, int Tiempo_condena, String delito, String conducta, String cedula, String Nombres, String Apellidos, String User, String password, String correo, Date fechaNacimiento) {
        super(cedula, Nombres, Apellidos, User, password, correo, fechaNacimiento);
        this.CodigoRecluso = CodigoRecluso;
        this.Tiempo_condena = Tiempo_condena;
        this.delito = delito;
        this.conducta = conducta;
    }


    public String GenerarIdRecluso(String cedula) {
        String id = "";
        //concaternar #P´+ 4 ultimos digitos de cedula
        id = ("#R" + cedula.substring(cedula.length() - 4));
        return id;
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

    public String getConducta() {
        return conducta;
    }

    public void setConducta(String conducta) {
        this.conducta = conducta;
    }
    
}
