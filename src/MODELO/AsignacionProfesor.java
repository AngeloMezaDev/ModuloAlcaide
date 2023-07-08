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
    private int idAsignacion;
    private String idDocente;
    private String nombreDocente;
    private String tipoAsignacion;
    private String nombreActividadTaller;
    private String idActividadTaller;
    private String nombreGrupo;

    public AsignacionProfesor(int idAsignacion, String idDocente, String nombreDocente, String tipoAsignacion, String nombreActividadTaller, String idActividadTaller, String nombreGrupo) {
        this.idAsignacion = idAsignacion;
        this.idDocente = idDocente;
        this.nombreDocente = nombreDocente;
        this.tipoAsignacion = tipoAsignacion;
        this.nombreActividadTaller = nombreActividadTaller;
        this.idActividadTaller = idActividadTaller;
        this.nombreGrupo = nombreGrupo;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
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

    public String getNombreGrupo() {
        return nombreGrupo;
    }
}

