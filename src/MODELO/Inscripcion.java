/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Ricardo
 */
public class Inscripcion extends Taller {
    private String idInscripcion;
    private String nombreRecluso;
    private String apellidosRecluso;
    private String correoRecluso;
    private String codigoRecluso;
    private String nombreGrupo;
    private int cupos;

    public Inscripcion(String nombreRecluso, String apellidosRecluso, String correoRecluso, String codigoRecluso, String nombreGrupo, int cupos, String idTaller, String nombreTaller, int cantidadGrupos, int capacidadMaxima, Date fechaCreacion, Date fechaVencimiento, int reduccionCondena) {
        super(idTaller, nombreTaller, cantidadGrupos, capacidadMaxima, fechaCreacion, fechaVencimiento, reduccionCondena);
        this.idInscripcion = "";
        this.nombreRecluso = nombreRecluso;
        this.apellidosRecluso = apellidosRecluso;
        this.correoRecluso = correoRecluso;
        this.codigoRecluso = codigoRecluso;
        this.nombreGrupo = nombreGrupo;
        this.cupos = cupos;
    }

    public String getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(String idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getNombreRecluso() {
        return nombreRecluso;
    }

    public void setNombreRecluso(String nombreRecluso) {
        this.nombreRecluso = nombreRecluso;
    }

    public String getApellidosRecluso() {
        return apellidosRecluso;
    }

    public void setApellidosRecluso(String apellidosRecluso) {
        this.apellidosRecluso = apellidosRecluso;
    }

    public String getCorreoRecluso() {
        return correoRecluso;
    }

    public void setCorreoRecluso(String correoRecluso) {
        this.correoRecluso = correoRecluso;
    }

    public String getCodigoRecluso() {
        return codigoRecluso;
    }

    public void setCodigoRecluso(String codigoRecluso) {
        this.codigoRecluso = codigoRecluso;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion= " + idInscripcion + ", nombreRecluso= " + nombreRecluso + ", apellidosRecluso= " + apellidosRecluso + ", correoRecluso=" + correoRecluso + ", codigoRecluso=" + codigoRecluso + ", nombreGrupo= " + nombreGrupo + ", cupos= " + cupos + '}';
    }
   
}
