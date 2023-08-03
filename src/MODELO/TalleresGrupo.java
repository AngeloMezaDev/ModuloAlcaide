/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class TalleresGrupo extends Taller{
    
    private String nombreGrupo;
    private int cupos;

    public TalleresGrupo(String nombreGrupo, int cupos, String idTaller, String nombreTaller, int cantidadGrupos, int capacidadMaxima, Date fechaCreacion, Date fechaVencimiento, int reduccionCondena) {
        super(idTaller, nombreTaller, cantidadGrupos, capacidadMaxima, fechaCreacion, fechaVencimiento, reduccionCondena);
        this.nombreGrupo = nombreGrupo;
        this.cupos= cupos;
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
    
    
    
}
