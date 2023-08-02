/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Yordan
 */
public class AsignacionRecluso {
    private String idAsignacion;
    private String idRecluso;
    private String nombreRecluso;
    private String tipoAsignacion;
    private String nombreActividadTaller;
    private String idActividadTaller;
    private String nombreGrupo;

    public AsignacionRecluso(String idAsignacion, String idRecluso, String nombreRecluso, String tipoAsignacion, String nombreActividadTaller, String idActividadTaller) {
        this.idAsignacion = idAsignacion;
        this.idRecluso = idRecluso;
        this.nombreRecluso = nombreRecluso;
        this.tipoAsignacion = tipoAsignacion;
        this.nombreActividadTaller = nombreActividadTaller;
        this.idActividadTaller = idActividadTaller;
    }
    
    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }
    

    public String getIdRecluso() {
        return idRecluso;
    }

    public void setIdRecluso(String idRecluso) {
        this.idRecluso = idRecluso;
    }

    public String getNombreRecluso() {
        return nombreRecluso;
    }

    public void setNombreRecluso(String nombreRecluso) {
        this.nombreRecluso = nombreRecluso;
    }


    public String getTipoAsignacion() {
        return tipoAsignacion;
    }

    public String getNombreActividadTaller() {
        return nombreActividadTaller;
    }

    public String getIdActividadTaller() {
        return idActividadTaller;
    }
}

