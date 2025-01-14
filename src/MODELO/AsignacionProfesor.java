/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Yordan
 */
public class AsignacionProfesor {
    private String idAsignacion;
    private String idDocente;
    private String nombreDocente;
    private String tipoAsignacion;
    private String nombreActividadTaller;
    private String idActividadTaller;
    private String nombreGrupo;

    public AsignacionProfesor(String idAsignacion, String idDocente, String nombreDocente, String tipoAsignacion, String nombreActividadTaller, String idActividadTaller, String nombreGrupo) {
        this.idAsignacion = idAsignacion;
        this.idDocente = idDocente;
        this.nombreDocente = nombreDocente;
        this.tipoAsignacion = tipoAsignacion;
        this.nombreActividadTaller = nombreActividadTaller;
        this.idActividadTaller = idActividadTaller;
        this.nombreGrupo = nombreGrupo;
    }

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(String tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
    }

    public String getNombreActividadTaller() {
        return nombreActividadTaller;
    }

    public void setNombreActividadTaller(String nombreActividadTaller) {
        this.nombreActividadTaller = nombreActividadTaller;
    }

    public String getIdActividadTaller() {
        return idActividadTaller;
    }

    public void setIdActividadTaller(String idActividadTaller) {
        this.idActividadTaller = idActividadTaller;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
   
    
}
